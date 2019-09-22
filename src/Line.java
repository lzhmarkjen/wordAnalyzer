import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

import Exception.*;
import javafx.util.Pair;
public class Line {
    private String line;
    private char[] token;
    private BigInteger num;
    private int i;
    private int j;

    public Line(String s) {
        i = 0;
        j = 0;
        num = new BigInteger("0");
        token = new char[1024];
        line = s;
    }

    private Pair<Integer, Symble> getsym(int index) throws UnRecognizeSymble, UnFinishedProgram {
        Symble symble;
        i = 0;
        clearToken();
        char curChar = line(index);
        try {
            while (Char.isSpace(line(index + i)) || Char.isNewline(line(index + i)) || Char.isTab(line(index + i))) {
                i++;
            }
            if (Char.isLetter(line(index + i))) {
                while (Char.isLetter(line(index + i)) || Char.isDigit(line(index + i))) {
                    catToken(line(index + i));
                    i++;
                }
                if (Reserve.isReserve(new String(token, 0, i - 1))) {
                    symble = Symble.RERSVSY;
                } else {
                    symble = Symble.IDSY;
                }
            } else if (Char.isDigit(line(index + i))) {
                while (Char.isDigit(line(index + i))) {
                    catToken(line(index + i));
                    i++;
                }
                num = transNum(token);
                symble = Symble.INTSY;
            } else if (Char.isColon(line(index + i))) {
                catToken(line(index + i));
                i++;
                if (Char.isEqu(line(index + i))) {
                    catToken(line(index + i));
                    i++;
                    symble = Symble.ASSIGNSY;
                } else {
                    symble = Symble.COLONSY;
                }
            } else if (Char.isPlus(line(index + i))) {
                catToken(line(index + i));
                i++;
                symble = Symble.PLUSSY;
            } else if (Char.isMinus(line(index + i))) {
                catToken(line(index + i));
                i++;
                symble = Symble.MINUSSY;
            } else if (Char.isStar(line(index + i))) {
                catToken(line(index + i));
                i++;
                symble = Symble.STARSY;
            } else if (Char.isLpar(line(index + i))) {
                catToken(line(index + i));
                i++;
                symble = Symble.LPARSY;
            } else if (Char.isRpar(line(index + i))) {
                catToken(line(index + i));
                i++;
                symble = Symble.RPARSY;
            } else if (Char.isComma(line(index + i))) {
                catToken(line(index + i));
                i++;
                symble = Symble.COMMASY;
            } else if (Char.isSemi(line(index + i))) {
                catToken(line(index + i));
                i++;
                symble = Symble.SEMISY;
            } else if (Char.isDivi(line(index + i))) {
                catToken(line(index + i));
                i++;
                if (Char.isStar(line(index + i))) {
                    do {
                        do {
                            catToken(line(index + i));
                            i++;
                        } while (!Char.isStar(line(index + i)));
                        do {
                            catToken(line(index + i));
                            i++;
                            if (Char.isDivi(line(index + i))) {
                                catToken(line(index + i));
                                i++;
                                return new Pair<>(i, Symble.COMMENTSY);
                            }
                        } while (Char.isStar(line(index + i)));
                    } while (!Char.isStar(line(index + i)));
                }
                symble = Symble.DIVISY;
            } else {
                throw new UnRecognizeSymble(line(index));
            }
            return new Pair<>(i, symble);
        } catch (StringIndexOutOfBoundsException e) {
            throw new UnFinishedProgram();
        }
    }

    public void run() throws UnRecognizeSymble, UnFinishedProgram {
        Map<Integer, Symble> map = new HashMap<>();
        for (int index = 0; index < line.length(); ) {
            Pair<Integer, Symble> result = getsym(index);
            index += result.getKey();
            map.put(result.getKey(), result.getValue());
            System.out.println(new String(token, 0, j)+" "+result.getValue());
        }

        print(map);
    }

    private void clearToken() {
        j = 0;
        i = 0;
        token = new char[line.length()];
    }

    private void catToken(char c) {
        token[j++] = c;
    }

    private void endToken() {
        token[i] = '\0';
    }

    private char line(int index) {
        return line.charAt(index);
    }

    private BigInteger transNum(char[] token) {
        String tmp = new String(token, 0, j);
        return new BigInteger(tmp);
    }

    private void print(Map<Integer, Symble> map) {
        for (int i : map.keySet()) {
            System.out.println(i + " " + map.get(i));
        }
    }
}