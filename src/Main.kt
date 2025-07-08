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
        var storedNums: String = ""
        var firstVal: Double = 0.0
        var secondVal: Double = 0.0

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

        fun clearShowResult() {
            if (showResult && !(listOf('/', '+', '-', '*').any { it in textField.text })) {
                textField.clear()
                storedNums = ""
                showResult = false
            } else {
                storedNums = ""
                showResult = false
            }
        }

        fun formatResult(value: Double): String =
            if (value % 1 == 0.0) {
                value.toInt().toString()
            } else {
                value.toString()
            }

        val input = textField.text

        val button1 = Button("7")
        button1.setOnAction {
            clearShowResult()
            textField.text += 7
            showResult = false
            if (listOf('/', '+', '-', '*').any { it in textField.text }) {
                storedNums += "7"
            }
        }
        val button2 = Button("8")
        button2.setOnAction {
            clearShowResult()
            textField.text += 8
            showResult = false
            if (listOf('/', '+', '-', '*').any { it in textField.text }) {
                storedNums += "8"
            }
        }
        val button3 = Button("9")
        button3.setOnAction {
            clearShowResult()
            textField.text += 9
            showResult = false
            if (listOf('/', '+', '-', '*').any { it in textField.text }) {
                storedNums += "9"
            }
        }

        val button5 = Button("4")
        button5.setOnAction {
            clearShowResult()
            textField.text += 4
            showResult = false
            if (listOf('/', '+', '-', '*').any { it in textField.text }) {
                storedNums += "4"
            }
        }
        val button6 = Button("5")
        button6.setOnAction {
            clearShowResult()
            textField.text += 5
            showResult = false
            if (listOf('/', '+', '-', '*').any { it in textField.text }) {
                storedNums += "5"
            }
        }
        val button7 = Button("6")
        button7.setOnAction {
            clearShowResult()
            textField.text += 6
            showResult = false
            if (listOf('/', '+', '-', '*').any { it in textField.text }) {
                storedNums += "6"
            }
        }
        val button9 = Button("1")
        button9.setOnAction {
            clearShowResult()
            textField.text += 1
            showResult = false
            if (listOf('/', '+', '-', '*').any { it in textField.text }) {
                storedNums += "1"
            }
        }
        val button10 = Button("2")
        button10.setOnAction {
            clearShowResult()
            textField.text += 2
            showResult = false
            if (listOf('/', '+', '-', '*').any { it in textField.text }) {
                storedNums += "2"
            }
        }
        val button11 = Button("3")
        button11.setOnAction {
            clearShowResult()
            textField.text += 3
            showResult = false
            if (listOf('/', '+', '-', '*').any { it in textField.text }) {
                storedNums += "3"
            }
        }
        val button14 = Button("0")
        button14.setOnAction {
            clearShowResult()
            textField.text += 0
            showResult = false
            if (listOf('/', '+', '-', '*').any { it in textField.text }) {
                storedNums += "0"
            }
        }

        val buttonPlus = Button("+")
        buttonPlus.setOnAction {
            firstVal = textField.text.toDouble()
            textField.text += "+"
        }
        val buttonMinus = Button("-")
        buttonMinus.setOnAction {
            firstVal = textField.text.toDouble()
            textField.text += "-"
        }
        val buttonMult = Button("*")
        buttonMult.setOnAction {
            firstVal = textField.text.toDouble()
            textField.text += "*"
        }

        val buttonDiv = Button("/")
        buttonDiv.setOnAction {
            firstVal = textField.text.toDouble()
            textField.text += "/"
        }
        val buttonClear = Button("C")
        buttonClear.setOnAction {
            textField.clear()
            storedNums = ""
            firstVal = 0.0
            secondVal = 0.0
        }
        val buttonDot = Button(".")
        buttonDot.setOnAction {
            clearShowResult()
            if (!storedNums.contains(".")) {
                storedNums += "."
                textField.text += "."
                showResult = false
            }
        }

        val buttonEquals = Button("=")
        buttonEquals.setOnAction {
            if (textField.text.isEmpty()) {
                textField.text = ""
            }

            secondVal = storedNums.toDouble()

            val multp = firstVal * secondVal
            val subt = firstVal - secondVal
            val div = firstVal / secondVal
            val add = firstVal + secondVal

            when {
                textField.text.contains("-") -> {
                    if (subt.toString().endsWith(".0")) {
                        textField.text = subt.toInt().toString().replace(".0", "")
                        storedNums = subt.toString()
                    } else {
                        textField.text = subt.toString()
                        storedNums = subt.toString()
                    }
                }

                textField.text.contains("+") -> {
                    if (add.toString().endsWith(".0")) {
                        textField.text = add.toInt().toString().replace(".0", "")
                        storedNums = add.toString()
                    } else {
                        textField.text = add.toString()
                        storedNums = add.toString()
                    }
                }

                textField.text.contains("*") -> {
                    if (multp.toString().endsWith(".0")) {
                        textField.text = multp.toInt().toString().replace(".0", "")
                        storedNums = multp.toString()
                    } else {
                        textField.text = multp.toString()
                        storedNums = multp.toString()
                    }
                }

                textField.text.contains("/") -> {
                    if (div.toString().endsWith(".0")) {
                        textField.text = div.toInt().toString().replace(".0", "")
                        storedNums = div.toString()
                    } else {
                        textField.text = div.toString()
                        storedNums = div.toString()
                    }
                }
            }
            showResult = true
        }

        grid.add(textField, 0, 0, 5, 1)

        grid.add(button1, 0, 1)
        grid.add(button2, 1, 1)
        grid.add(button3, 2, 1)
        grid.add(buttonDiv, 3, 1)

        grid.add(button5, 0, 2)
        grid.add(button6, 1, 2)
        grid.add(button7, 2, 2)
        grid.add(buttonMult, 3, 2)

        grid.add(button9, 0, 3)
        grid.add(button10, 1, 3)
        grid.add(button11, 2, 3)
        grid.add(buttonMinus, 3, 3)

        grid.add(buttonDot, 0, 4)
        grid.add(button14, 1, 4)
        grid.add(buttonClear, 2, 4)
        grid.add(buttonPlus, 3, 4)
        grid.add(buttonEquals, 4, 1, 1, 4)

        grid.padding = Insets(10.0)

        val buttons =
            listOf(
                button1,
                button2,
                button3,
                button5,
                button6,
                button7,
                button9,
                button10,
                button11,
                button14,
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
    }
}

fun main() {
    Application.launch(MyApp::class.java)
}
