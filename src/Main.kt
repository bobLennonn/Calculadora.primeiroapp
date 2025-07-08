import javafx.application.Application
import javafx.geometry.Insets
import javafx.geometry.Pos
import javafx.scene.Scene
import javafx.scene.control.Button
import javafx.scene.control.TextField
import javafx.scene.layout.ColumnConstraints
import javafx.scene.layout.GridPane
import javafx.scene.layout.Priority
import javafx.scene.layout.RowConstraints
import javafx.stage.Stage

class MyApp : Application() {
    @Suppress("ktlint:standard:max-line-length")
    override fun start(stage: Stage) {
        var showResult = false
        var firstVal: Double = 0.0
        var secondVal: Double = 0.0
        var lastResult: Double = 0.0

        val grid = GridPane()
        grid.hgap = 10.0
        grid.vgap = 10.0

        val textField = TextField()
        textField.promptText = ""
        textField.style =
            "-fx-font-size: 27px; -fx-padding: 10px; -fx-border-color: #cccccc;-fx-border-width: 2px;-fx-background-radius: 5px;-fx-border-radius: 5px; -fx-font-family: 'Arial'".trimIndent()
        textField.alignment = Pos.CENTER_RIGHT
        textField.maxWidth = Double.MAX_VALUE
        textField.maxHeight = Double.MAX_VALUE

        GridPane.setHgrow(textField, Priority.ALWAYS)
        GridPane.setVgrow(textField, Priority.ALWAYS)

        fun formatResult(value: Double): String =
            if (value % 1 == 0.0) {
                value.toInt().toString()
            } else {
                value.toString()
            }

        fun setupDigitButton(
            btn: Button,
            digit: String,
        ) {
            btn.setOnAction {
                if (showResult) {
                    textField.text = digit
                    showResult = false
                } else {
                    textField.text += digit
                }
            }
        }

        fun limitCharOnTextField(
            textField: TextField,
            charToLimit: Char,
            maxOcurrences: Int,
        ) {
            textField.textProperty().addListener { observable, oldValue, newValue ->
                val occurrences = newValue.count { it == charToLimit }
                if (occurrences > maxOcurrences) {
                    // Reverte para o texto anterior se passar do limite
                    textField.text = oldValue
                }
            }
        }

        val button7 = Button("7")
        val button8 = Button("8")
        val button9 = Button("9")
        val button4 = Button("4")
        val button5 = Button("5")
        val button6 = Button("6")
        val button1 = Button("1")
        val button2 = Button("2")
        val button3 = Button("3")
        val button0 = Button("0")

        setupDigitButton(button7, "7")
        setupDigitButton(button8, "8")
        setupDigitButton(button9, "9")
        setupDigitButton(button4, "4")
        setupDigitButton(button5, "5")
        setupDigitButton(button6, "6")
        setupDigitButton(button1, "1")
        setupDigitButton(button2, "2")
        setupDigitButton(button3, "3")
        setupDigitButton(button0, "0")

        val buttonPlus = Button("+")
        buttonPlus.setOnAction {
            if (showResult) {
                firstVal = lastResult
                textField.text = formatResult(firstVal) + "+"
                showResult = false
            } else {
                firstVal = textField.text.toDoubleOrNull() ?: 0.0
                textField.text += "+"
            }
        }
        val buttonMinus = Button("-")
        buttonMinus.setOnAction {
            if (showResult) {
                firstVal = lastResult
                textField.text = formatResult(firstVal) + "-"
                showResult = false
            } else {
                firstVal = textField.text.toDoubleOrNull() ?: 0.0
                textField.text += "-"
            }
        }
        val buttonMult = Button("*")
        buttonMult.setOnAction {
            if (showResult) {
                firstVal = lastResult
                textField.text = formatResult(firstVal) + "*"
                showResult = false
            } else {
                firstVal = textField.text.toDoubleOrNull() ?: 0.0
                textField.text += "*"
            }
        }

        val buttonDiv = Button("/")
        buttonDiv.setOnAction {
            if (showResult) {
                firstVal = lastResult
                textField.text = formatResult(firstVal) + "/"
                showResult = false
            } else {
                firstVal = textField.text.toDoubleOrNull() ?: 0.0
                textField.text += "/"
            }
        }
        val buttonClear = Button("C")
        buttonClear.setOnAction {
            textField.clear()
            firstVal = 0.0
            secondVal = 0.0
        }

        val buttonDot = Button(".")
        buttonDot.setOnAction {
            val dotQnty = textField.text.count { it == '.' }
            if (!textField.text.contains(".") || textField.text.contains(".")) {
                textField.text += "."
            }
            if (dotQnty > 2) {
                limitCharOnTextField(textField, '.', 2)
            }
        }

        val buttonEquals = Button("=")

        grid.add(textField, 0, 0, 5, 1)

        grid.add(button7, 0, 1)
        grid.add(button8, 1, 1)
        grid.add(button9, 2, 1)
        grid.add(buttonDiv, 3, 1)

        grid.add(button4, 0, 2)
        grid.add(button5, 1, 2)
        grid.add(button6, 2, 2)
        grid.add(buttonMult, 3, 2)

        grid.add(button1, 0, 3)
        grid.add(button2, 1, 3)
        grid.add(button3, 2, 3)
        grid.add(buttonMinus, 3, 3)

        grid.add(buttonDot, 0, 4)
        grid.add(button0, 1, 4)
        grid.add(buttonClear, 2, 4)
        grid.add(buttonPlus, 3, 4)
        grid.add(buttonEquals, 4, 1, 1, 4)

        grid.padding = Insets(10.0)

        val buttons =
            listOf(
                button7,
                button8,
                button9,
                button4,
                button5,
                button6,
                button1,
                button2,
                button3,
                button0,
                buttonPlus,
                buttonMinus,
                buttonMult,
                buttonDiv,
                buttonEquals,
                buttonClear,
                buttonDot,
            )

        buttons.forEach { btn ->
            btn.prefWidth = 50.0
            btn.prefHeight = 40.0
            btn.maxWidth = Double.MAX_VALUE
            btn.maxHeight = Double.MAX_VALUE
            btn.style = "-fx-font-size: 30px; -fx-font-family: 'Arial';"
            GridPane.setHgrow(btn, Priority.ALWAYS)
            GridPane.setVgrow(btn, Priority.ALWAYS)
        }

        for (i in 0 until 5) {
            val col = ColumnConstraints()
            col.percentWidth = 25.0
            grid.columnConstraints.add(col)
        }

        for (i in 0 until 5) {
            val row = RowConstraints()
            row.percentHeight = 20.0
            grid.rowConstraints.add(row)
        }

        val scene = Scene(grid)
        stage.sizeToScene()
        stage.isResizable = true

        stage.title = "Calculadora"
        stage.scene = scene
        stage.show()

        buttonEquals.setOnAction {
            val input = textField.text
            if (textField.text.isEmpty()) {
                textField.text = ""
            }

            when {
                input.contains("-") -> {
                    val (a, b) = input.split("-")
                    val result = a.toDouble() - b.toDouble()
                    textField.text = formatResult(result)
                    lastResult = result
                }

                input.contains("+") -> {
                    val (a, b) = input.split("+")
                    val result = a.toDouble() + b.toDouble()
                    textField.text = formatResult(result)
                    lastResult = result
                }

                input.contains("*") -> {
                    val (a, b) = input.split("*")
                    val result = a.toDouble() * b.toDouble()
                    textField.text = formatResult(result)
                    lastResult = result
                }

                input.contains("/") -> {
                    val (a, b) = input.split("/")
                    val result = a.toDouble() / b.toDouble()
                    textField.text = formatResult(result)
                    lastResult = result
                }
            }
            showResult = true
        }
    }
}

fun main() {
    Application.launch(MyApp::class.java)
}
