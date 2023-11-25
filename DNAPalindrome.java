import java.util.Scanner;

public class DNAPalindrome {
    
    public static void main(String Args[]){

        StringDoubleEndedQueueImpl<String> dna = new StringDoubleEndedQueueImpl<String>();
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        boolean flag = true; //an einai egkyrh h akoloythia toy dna, enallaktika tha eftiaxna exception alla psilovariemai
        boolean WaCri = true; //an einai Watson-Crick complemented palindrome
        
        for(int i = 0; i < input.length(); i++) { //1 loop --> O(N)
            char lt = input.charAt(i); //kathe char jexwrista gia na to kanoyme node sthn queue h kai oxi...

            if (lt == 'A'){
                dna.addFirst(Character.toString('T'));
                if (input.charAt(input.length() - i - 1) != 'T'){
                    WaCri = false;
                }
            }else if(lt == 'T'){
                dna.addFirst(Character.toString('A'));
                if (input.charAt(input.length() - i - 1) != 'A'){
                    WaCri = false;
                }
            }else if(lt == 'C'){
                dna.addFirst(Character.toString('G'));
                if (input.charAt(input.length() - i - 1) != 'G'){
                    WaCri = false;
                }
            }else if(lt == 'G'){
                dna.addFirst(Character.toString('C'));
                if (input.charAt(input.length() - i - 1) != 'C'){
                    WaCri = false;
                }
            }else{
                flag = false;
            }
        }

        if(flag){
            if( WaCri || (dna.size() == 1 && dna.getFirst().equals(""))){ //den katalavainw gt to keno ikanopoiei alla afoy to leei sthn ekfwnhsh...
                System.out.println("DNA chain is Watson-Crick complemented palindrome");
            }else{
                System.out.println("DNA chain is not Watson-Crick complemented palindrome");
            }
        }else{
            System.out.println("Please enter correct DNA chain");
        }
    }
}
