import java.util.Scanner;

public class DNAPalindrome {
    
    public static void main(String Args[]){

        StringDoubleEndedQueueImpl dna = new StringDoubleEndedQueueImpl();
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        boolean flag = false;
        boolean WaCri = false;
        
        for(int i = 0; i < input.length(); i++) {
            char lt = input.charAt(i);
            if (lt == 'A'){
                dna.addFirst(Character.toString('T'));
                if (input.charAt(input.length() - i - 1) != 'T'){
                    WaCri = true;
                }
            }else if(lt == 'T'){
                dna.addFirst(Character.toString('A'));
                if (input.charAt(input.length() - i - 1) != 'A'){
                    WaCri = true;
                }
            }else if(lt == 'C'){
                dna.addFirst(Character.toString('G'));
                if (input.charAt(input.length() - i - 1) != 'G'){
                    WaCri = true;
                }
            }else if(lt == 'G'){
                dna.addFirst(Character.toString('C'));
                if (input.charAt(input.length() - i - 1) != 'C'){
                    WaCri = true;
                }
            }else{
                flag = true;
            }
        }
        if(!flag){
            if( !(WaCri) || (dna.size() == 1 && dna.getFirst().equals(""))){
                System.out.println("DNA chain is Watson-Crick complemented palindrome");
            }else{
                System.out.println("DNA chain is not Watson-Crick complemented palindrome");
            }
        }else{
            System.out.println("Please enter correct DNA chain");
        }
    }
}
