package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import org.w3c.dom.ls.LSOutput;

import java.util.*;
import java.util.stream.Stream;

public class Application {
    static boolean run = true;
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        String result = "";
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }


        boolean run = true;
        while(run) {
            System.out.println("숫자 야구 게임을 시작합니다.");
            System.out.print("숫자를 입력해주세요 : ");
            String answer = Console.readLine();
            System.out.println(answer);


            result = checkCount(computer, answer);
            System.out.println(result);

            if (result.equals("3스트라이크")) {
                answer=Console.readLine();
                if(answer.equals("1")){
                    makeNum(computer);
                    System.out.println("게임을 재시작 합니다.");
                    computer.set(0 , 5);
                    computer.set(1 , 8);
                    computer.set(2 , 9);
                    System.out.println(computer);
                }
                else{
                    System.out.println("게임 종료");
                    run=false;
                }
            }
        }
    }



    private static List<Integer> makeNum(List<Integer> computer){
        computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }

        return computer;
    }


    private static boolean checkAnswer(String answer){
        if(answer.length()!=3)
            return false;

        List<Integer> duplList = new ArrayList<>();
        for(int i =0; i<answer.length()-1; i++){
            char dupl = answer.charAt(i);
            int duplNum = dupl-'0';
            duplList.add(duplNum);
        }

        Set<Integer> dupl = new HashSet<>(duplList);
        if(dupl.size()!=duplList.size())
            return false;


        return true;
    }


    private static String checkCount(List<Integer> computer , String answer){
        int strike=0;
        int ball = 0;


        System.out.println(checkAnswer(answer));
        if(!checkAnswer(answer)){
            throw  new IllegalArgumentException();
        }

        for(int i=0; i<computer.size(); i++){
            char answerChar = answer.charAt(i);
            int answerCharInt = answerChar-'0';
            if(answerCharInt==computer.get(i)){
                strike++;
            }
            else if (computer.contains(answerCharInt)){
                ball++;
            }
        }

        String result = "";

        if(ball>0){
            result+=ball+"볼";
            if(strike>0)
                result+=" ";
        }
        if(strike>0)
            result+=strike+"스트라이크";

        if(ball==0 && strike==0)
            result="낫싱";


        return result;
    }


}
