public class Roman_to_integer {

    public int romanToInt(String s) {
        String str = ".";
        s += ".";
        str += s;

        int sum = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == 'M') {
                if (str.charAt(i - 1) == 'C') {
                    sum += 900;
                } else {
                    sum += 1000;
                }

            }
            if (str.charAt(i) == 'D') {
                if (str.charAt(i - 1) == 'C') {
                    sum += 400;
                } else {
                    sum += 500;
                }

            }
            if (str.charAt(i) == 'C') {
                if (str.charAt(i + 1) != 'M' && str.charAt(i + 1) != 'D') {
                    if (str.charAt(i - 1) == 'X') {
                        sum += 90;
                    } else {
                        sum += 100;
                    }
                }

            }
            if (str.charAt(i) == 'L') {
                if (str.charAt(i - 1) == 'X') {
                    sum += 40;
                } else {
                    sum += 50;
                }
            }
            if (str.charAt(i) == 'X') {
                if (str.charAt(i + 1) != 'L' && str.charAt(i + 1) != 'C') {
                    if (str.charAt(i - 1) == 'I') {
                        sum += 9;
                    } else {
                        sum += 10;
                    }
                }
            }
            if (str.charAt(i) == 'V') {
                if (str.charAt(i - 1) == 'I') {
                    sum += 4;
                } else {
                    sum += 5;
                }
            }
            if (str.charAt(i) == 'I') {
                if (str.charAt(i + 1) != 'X' && str.charAt(i + 1) != 'V') {
                    sum += 1;
                }
            }
        }
        return sum;
    }

}
