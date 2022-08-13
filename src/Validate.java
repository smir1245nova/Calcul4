public class Validate {
    // BAJINDATOP
    private boolean isRoman(String inputStr) {
        return inputStr.matches("^I$|^II$|^III$|^IV$|^V$|^VI$|^VII$|^VIII$|^IX$|^X$");
    }

    private boolean isStringInt(String s) {
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException ex) {
            return false;
        }
    }

    public String validateInput(String input1, String input2, String operator) {
        String result = "";

        if (!operator.matches("[-+*/]{1}")) {
            throw new RuntimeException("Неправильно введен знак исчисления");
        }

        if (isRoman(input1) && isStringInt(input2)) {
            throw new RuntimeException("Разные системы исчисления");// разные исчисления
        }
          else  if (isStringInt(input1) && isRoman(input2)) {
                throw new RuntimeException("Разные системы исчисления");// разные исчисления
            }
            if (!isRoman(input1) && !isStringInt(input1) ) {
                throw new RuntimeException("Римские числа находятся вне указанных пределов");
            }else if(!isRoman(input2) && !isStringInt(input2) ){
                throw new RuntimeException("Римские числа находятся вне указанных пределов");
            }

            int op1 = 0;
            int op2 = 0;

            if (isRoman(input1)) {
                ConvertRoman romanOp = new ConvertRoman();
                op1 = romanOp.romanToInt(input1);
                op2 = romanOp.romanToInt(input2);
            } else {
                op1 = Integer.parseInt(String.valueOf(input1));
                op2 = Integer.parseInt(String.valueOf(input2));
            }

            if (((op1 < 1) || (op1 > 10)) || ((op2 < 1) || (op2 > 10))) {
                throw new RuntimeException("Введенные числа находятся вне указанных пределов");
            }

            if (isRoman(input1)) {
                result = "roman";
            } else {
                result = "decimal";
            }

            return result;
        }

    }

