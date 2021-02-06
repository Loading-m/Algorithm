import java.util.Arrays;

public class StackTest {

    public static void main(String[] args) {
     /*  SeqStack<Integer> seqStack = new SeqStack<>();
       seqStack.push(1);
       seqStack.push(2);
       seqStack.push(3);
       System.out.println(seqStack.pop());
       System.out.println(seqStack.pop());
       System.out.println(seqStack.peek());
       System.out.println(seqStack.isEmpty());
       System.out.println(seqStack.pop());*/

        String trueBracketstr = "{[()()]}";
        System.out.println(bracketCheck(trueBracketstr));
        String falseBracketstr = "{[()()]}}";
        System.out.println(bracketCheck(falseBracketstr));

        String optStr = "((9/(5-(1+1)))*3)-(2+(1+1))";
        String postfixExp = infixTopostfixExp(optStr);
        System.out.println("原中缀表达式为：" + optStr);
        System.out.println("中转后缀表达式为：" + postfixExp);
        System.out.println("计算后缀表达式值为：" + calcPostfixExp(postfixExp));
    }

    //括号合法性检查
    public static Boolean bracketCheck(String str) {
        SeqStack<Character> seqStack = new SeqStack<>();
        if (null != str && "" != str) {
            char[] chars = str.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                if (chars[i] == '(' || chars[i] == '[' || chars[i] == '{') {
                    //遇到左括号入栈
                    seqStack.push(chars[i]);
                } else {
                    //遇到了右括号
                    if (seqStack.isEmpty()) { //如果栈为空，说明此时扫到的右括号没有对应的左括号
                        return false; // 匹配失败
                    }

                    Character pop = seqStack.pop();
                    char topChar = pop.charValue();
                    //匹配校验
                    //如果栈顶不与当前右括号对应，匹配失败
                    if (chars[i] == ')' && topChar != '(') {
                        return false;
                    }
                    if (chars[i] == ']' && topChar != '[') {
                        return false;
                    }
                    if (chars[i] == '}' && topChar != '{') {
                        return false;
                    }
                    //继续循环，遍历下一个字符
                }
            }
            //所有字符都遍历完成
            //检查栈如果非空，说明没有没有左括号匹配的右括号出现，匹配失败
            return seqStack.isEmpty();
        }
        return false;
    }


    //计算后缀表达式值
    public static Integer calcPostfixExp(String str) {
        //操作数栈
        SeqStack<Integer> operatorStack = new SeqStack<>(str.length());
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            //1.遇到操作数 [0-9] 直接入栈
            if (Character.isDigit(chars[i])) {
                operatorStack.push(Integer.parseInt(String.valueOf(chars[i])));
                continue;
            }

            //遇到的是运算符，弹出两个操作数
            //先弹出的是右操作数，注意顺序
            int rightOpt = operatorStack.pop();
            int leftOpt = operatorStack.pop();
            if (chars[i] == '+') {
                operatorStack.push(leftOpt + rightOpt);
            } else if (chars[i] == '-') {
                operatorStack.push(leftOpt - rightOpt);
            } else if (chars[i] == '*') {
                operatorStack.push(leftOpt * rightOpt);
            } else if (chars[i] == '/') {
                operatorStack.push(leftOpt / rightOpt);
            }
        }
        return operatorStack.pop();
    }


    // 中缀表达式转后缀表达式
    public static String infixTopostfixExp(String str) {
        //运算符栈
        SeqStack<Character> operatorStack = new SeqStack<>(str.length());
        //存储后缀表达式
        StringBuilder postfixStr = new StringBuilder();
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            //1.遇到操作数 [0-9] 直接加入后缀表达式
            if (Character.isDigit(chars[i])) {
                postfixStr.append(chars[i]);
                continue;
            }

            //2.如果遇到界限符 ()
            if (chars[i] == '(') { //遇到 ( 直接入栈
                operatorStack.push(chars[i]);
                continue;
            } else if (chars[i] == ')') { //遇到 ) 需要依次弹出栈内运算符并加入后缀表达式，直至弹出(为止
                while (!operatorStack.isEmpty()) {
                    char topOpt = operatorStack.pop().charValue();
                    if (topOpt == '(') {
                        break;
                    }
                    postfixStr.append(topOpt);
                }
                continue;
            }

            //3.遇到预算符 -+*/
            //依次弹出栈中优先级高于或等于当前运算符的所有运算符
            //如果碰到（ 或者 栈空则停止
            if (chars[i] == '-' || chars[i] == '+') {
                //由于这两个运算符优先级相等，且优先级最低，所以可以弹出栈内所有运算符
                while (!operatorStack.isEmpty()) {
                    char topOpt = operatorStack.peek().charValue();
                    if (topOpt == '(') {
                        break;
                    }
                    postfixStr.append(operatorStack.pop().charValue());
                }
                // 然后将当前运算符压入栈中
                operatorStack.push(chars[i]);
                continue;
            }
            if (chars[i] == '*' || chars[i] == '/') {
                //高优先级的运算符
                while (!operatorStack.isEmpty()) {
                    char topOpt = operatorStack.peek().charValue();
                    if (topOpt == '(') {
                        break;
                    }
                    //判断栈顶元素的优先级
                    if (topOpt == '*' || topOpt == '/') {
                        postfixStr.append(operatorStack.pop().charValue());
                    } else if (topOpt == '-' || topOpt == '+') {
                        //栈顶运算符低于当前运算符
                        break;
                    }
                }
                operatorStack.push(chars[i]);
                continue;
            }
        }

        //将栈中的所有运算符依次加入后缀表达式中
        while (!operatorStack.isEmpty()) {
            postfixStr.append(operatorStack.pop().charValue());
        }
        return postfixStr.toString();
    }
}
