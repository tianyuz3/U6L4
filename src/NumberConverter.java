public class NumberConverter {
    int[] digits;
    int base;

    String hex;

    int decimal;

    public NumberConverter(int number, int base) {
        String numberAsString = Integer.toString(number);
        digits = new int[numberAsString.length()];
        for (int i = 0; i < numberAsString.length(); i++) {
            String single = numberAsString.substring(i, i + 1);
            int d = Integer.parseInt(single);
            digits[i] = d;
        }
        this.base = base;
    }

    public NumberConverter(String number, int b) {
        hex = number;
        base = b;
    }

    public NumberConverter(int number, int base, int something) {
        decimal = number;
        this.base = base;
    }

    public String displayOriginalNumber() {
        String o = "";
        for (int i = 0; i < digits.length; i++) {
            o = o + digits[i];
        }
        o = o + "\n";
        return o;
    }

    public int getBase() {
        return base;
    }

    public int getNumber() {
        String num = "";
        int result = 0;
        for (int i = 0; i < digits.length; i++) {
            num = num + digits[i];
        }
        result = Integer.parseInt(num);
        return result;
    }


    public int[] getDigits() {
        return digits;
    }

    public int hexToInt(String s) {
        int curr = 0;


        if (s.equals("A")) {
            curr = 10;
        } else if (s.equals("B")) {
            curr = 11;
        } else if (s.equals("C")) {
            curr = 12;
        } else if (s.equals("D")) {
            curr = 13;
        } else if (s.equals("E")) {
            curr = 14;
        } else if (s.equals("F")) {
            curr = 15;
        } else {
            curr = Integer.parseInt(s);
        }


        return curr;
    }

    public String intToHex(String s) {
        String re = "";
        if (s.equals("10") || s.equals("10.0")) {
            re = "A";
        } else if (s.equals("11") || s.equals("11.0")) {
            re = "B";
        } else if (s.equals("12") || s.equals("12.0")) {
            re = "C";
        } else if (s.equals("13") || s.equals("13.0")) {
            re = "D";
        } else if (s.equals("14") || s.equals("14.0")) {
            re = "E";
        } else if (s.equals("15") || s.equals("15.0")) {
            re = "F";
        } else {
            re = s;
        }
        return re;
    }

    public String hexToBinary() {
        int curr = 0;
        String binary = "";
        String reversed = "";
        for (int i = 0; i < hex.length(); i++) {
            if (hex.charAt(i) == 'A') {
                curr = 10;
            } else if (hex.charAt(i) == 'B') {
                curr = 11;
            } else if (hex.charAt(i) == 'C') {
                curr = 12;
            } else if (hex.charAt(i) == 'D') {
                curr = 13;
            } else if (hex.charAt(i) == 'E') {
                curr = 14;
            } else if (hex.charAt(i) == 'F') {
                curr = 15;
            } else {
                curr = Integer.parseInt(hex.substring(i, i + 1));
            }

            for (int j = curr; j != 0; j = j / 2) {
                if (j % 2 == 0) {
                    binary += "0";
                } else {
                    binary += "1";
                }
            }
            if (i != 0) {
                if (binary.length() == 1) {
                    binary += "000";
                }
                if (binary.length() == 2) {
                    binary += "00";
                }
                if (binary.length() == 3) {
                    binary += "0";
                }
            }

            for (int k = binary.length() - 1; k != -1; k--) {
                reversed += binary.substring(k, k + 1);
            }
            binary = "";
        }

        return reversed;
    }

    public String convertToAnyBase(int s) {
        String conversion = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz+/";
        return conversion.substring(s, s + 1);
    }

    public String convertToBase() {
        String h = "";
        String result = "";
        double remainder = 0;
        String single = "";
        int remainderAsInt = 0;
        String reverse = "";
        for (int i = getNumber(); i != 0; i /= base) {
            remainder = i % base;
            remainderAsInt = (int) remainder;
            single = convertToAnyBase(remainderAsInt);
            result += single;
        }
        for (int i = result.length() - 1; i != -1; i--) {
            reverse += result.substring(i, i + 1);
        }
        result = reverse;
        return result;
    }

    public int[] convertToDecimal() {
        int[] newList = new int[1];
        int result = 0;
        int count = 0;
        if (base == 2) {
            for (int i = digits.length - 1; i > -1; i--) {
                if (digits[count] == 1) {
                    result += Math.pow(2, i);
                }
                count++;
            }
        } else if (base == 8) {
            for (int i = digits.length - 1; i >= 0; i--) {
                result += Math.pow(8, count) * digits[i];
                count++;
            }
        } else if (base == 16) {
            int c = 0;
            for (int i = hex.length() - 1; i >= 0; i--) {
                result += hexToInt(hex.substring(c, c + 1)) * Math.pow(16, i);
                c++;
            }
        }
        newList[0] = result;
        return newList;
    }


    private String three() {
        String three = "";
        int sum = 0;
        if (digits.length % 3 == 0) {
            three = "" + getNumber();
        }
        if (digits.length % 3 == 1) {
            three = "00" + getNumber();
        } else if (digits.length % 3 == 2) {
            three = "0" + getNumber();
        }
        return three;


    }


    public int[] convertToBinary() {
        String binary = "";
        String reversed = "";
        int[] result = new int[1];
        if (base == 10) {
            for (int i = getNumber(); i != 0; i = i / 2) {
                if (i % 2 == 0) {
                    binary += "0";
                } else {
                    binary += "1";
                }

            }

            for (int i = binary.length() - 1; i != -1; i--) {
                reversed += binary.substring(i, i + 1);
            }
            result[0] = Integer.parseInt(reversed);
        } else if (base == 8) {
            String octal = "";
            int quotient = 0;
            for (int i = 0; i < digits.length; i++) {
                quotient = digits[i];
                for (int divisor = 4; divisor > 0; divisor /= 2) {
                    if (quotient / divisor == 1) {
                        quotient -= divisor;
                        octal += "1";
                    } else {
                        octal += "0";
                    }
                }

            }
            if (octal.indexOf("1") != 0) {
                octal = octal.substring(octal.indexOf("1"));
            }
            result[0] = Integer.parseInt(octal);
        } else if (base == 16 ) {
            int b = Integer.parseInt(hexToBinary());
            result[0] = b;


        }

        return result;
    }

    public int[] convertToOctal() {
        int[] result = new int[1];
        String remainder = "";
        String reversedRemainder = "";
        if (base == 10) {
            for (int i = getNumber(); i > 0; i /= 8) {
                remainder += i % 8;
            }
            for (int i = remainder.length() - 1; i != -1; i--) {
                reversedRemainder += remainder.substring(i, i + 1);
            }
            result[0] = Integer.parseInt(reversedRemainder);
        } else if (base == 2) {

            int sum = 0;
            String r = "";
            int index = 0;
            for (int i = 0; i < three().length(); i += 3) {
                for (int h = 4; h >= 1; h /= 2) {
                    if (three().substring(index, index + 1).equals("1")) {
                        sum += h;
                    }
                    index++;
                }
                r += sum;
                sum = 0;
            }
            result[0] = Integer.parseInt(r);
        } else if (base == 16) {
            int sum = 0;
            int c = 0;
            for (int n = hex.length() - 1; n >= 0; n--) {
                sum += hexToInt(hex.substring(c, c + 1)) * Math.pow(16, n);
                c++;
            }
            String remain = "";
            for (int i = sum; i != 0; i /= 8) {
                remain += i % 8;
            }
            String re = "";
            for (int n = remain.length() - 1; n != -1; n--) {
                re += remain.substring(n, n + 1);
            }

            result[0] = Integer.parseInt(re);
        }

        return result;
    }


    public boolean checkValue(String s) {
        if (base == 2) {
            for (int i = 0; i < s.length(); i++) {
                if (!s.substring(i, i + 1).equals("0") && !s.substring(i, i + 1).equals("1")) {
                    return false;
                }
            }
        } else if (base == 8) {
            if (s.substring(0, 1).equals("0")) {
                return false;
            }

            if (s.contains("8") || s.contains("9")) return false;
        } else if (s.substring(0, 1).equals("0")) {
            return false;
        } else if(base == 16){
            String hexList = "123456789ABCDEF";
            for(int k = 0 ; k<s.length()-1 ;k++){
                if(!hexList.contains(s.substring(k,k+1))){
                    return false;
                }
            }
        } else{return true;}

            return true;

    }

    public boolean checkBase(String b) {
        if (!b.equals("2") && !b.equals("8") && !b.equals(("10")) && !b.equals("16")) {
            return false;
        }
        return true;
    }

    public void convert() {

        if (base == 2) {
            System.out.println("Octal Number: " + convertToOctal()[0]);
            System.out.println("Decimal Number: " + convertToDecimal()[0]);
            System.out.println("Hexadecimal Number : " + convertToHex());
        } else if (base == 8) {
            System.out.println("Binary Number: " + convertToBinary()[0]);
            System.out.println("Decimal Number: " + convertToDecimal()[0]);
            System.out.println("Hexadecimal Number : " + convertToHex());
        } else if (base == 10) {
            System.out.println("Binary Number: " + convertToBinary()[0]);
            System.out.println("Octal Number: " + convertToOctal()[0]);
            System.out.println("Hexadecimal Number : " + convertToHex());
        } else {
            System.out.println("Binary Number: " + convertToBinary()[0]);
            System.out.println("Octal Number: " + convertToOctal()[0]);
            System.out.println("Decimal Number: " + convertToDecimal()[0]);
        }
    }

    public String convertToHex() {
        String result = "";
        if (base == 2) {
            int decimal = 0;
            int count = 0;
            for (int i = digits.length - 1; i > -1; i--) {
                if (digits[count] == 1) {
                    decimal += Math.pow(2, i);
                }
                count++;
            }
            String h = "";

            double remainder = 0;
            String single = "";
            int remainderAsInt = 0;
            String reverse = "";
            for (int i = decimal; i != 0; i /= 16) {
                remainder = i % 16.0;
                remainderAsInt = (int) remainder;
                single = intToHex(Integer.toString(remainderAsInt));
                result += single;
            }
            for (int i = result.length() - 1; i != -1; i--) {
                reverse += result.substring(i, i + 1);
            }
            result = reverse;
        } else if (base == 8) {
            int decimal = 0;
            int count = 0;
            for (int i = digits.length - 1; i >= 0; i--) {
                decimal += Math.pow(8, count) * digits[i];
                count++;
            }
            String h = "";

            double remainder = 0;
            String single = "";
            int remainderAsInt = 0;
            String reverse = "";
            for (int i = decimal; i != 0; i /= 16) {
                remainder = i % 16.0;
                remainderAsInt = (int) remainder;
                single = intToHex(Integer.toString(remainderAsInt));
                result += single;
            }
            for (int i = result.length() - 1; i != -1; i--) {
                reverse += result.substring(i, i + 1);
            }
            result = reverse;
        } else if (base == 10) {
            String h = "";

            double remainder = 0;
            String single = "";
            int remainderAsInt = 0;
            String reverse = "";
            for (int i = getNumber(); i != 0; i /= 16) {
                remainder = i % 16.0;
                remainderAsInt = (int) remainder;
                single = intToHex(Integer.toString(remainderAsInt));
                result += single;
            }
            for (int i = result.length() - 1; i != -1; i--) {
                reverse += result.substring(i, i + 1);
            }
            result = reverse;
        }
        return result;
    }
    public boolean check64Base(int b){
        if(b>64 || b<1){
            return false;
        }
        return true;
    }
    }
