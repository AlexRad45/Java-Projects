
/**
 *
 * @author amrad
 */
import java.util.Random;

//class HugeInteger 
public class HugeInteger {
    private int array[];
    private int size=40;
    private boolean negative;
    //HugeInteger random constructor 
    public HugeInteger(int n) throws IllegalArgumentException{
        int i, random;
        size = n;
        if(n >= 1){
            Random rand = new Random();
            random =rand.nextInt(2);
            if(random==0){
                negative=false;
            }else{
                negative=true;
            }
            random = rand.nextInt(9)+1;
            array = new int[size];
            array[0]=random;
            for(i = 1;i < n; i++){
                random = rand.nextInt(10);
                array[i] = random;
            }
        }else{
            throw new IllegalArgumentException("Argument does not meet specifications of constructor");
        }
    }
    //HugeInteger string constructor
    public HugeInteger(String val) throws IllegalArgumentException{
        size=val.length();
        if(size<1){
            throw new IllegalArgumentException("Argument does not meet specifications of constructor");
        }
        char c = val.charAt(0);
          if(c == '-' || (48 <= c && c <= 57)){
              if(c == '-'){
                  negative = true;
                  size--;
              }else{
                  negative = false;
              }

            array = new int[size];
            
            int k=0;
            if(negative == true){
                for(int i=1;i<=size;i++){
                    c = val.charAt(i);
                    if(48 <= c && c <= 57){
                        array[k] = c - 48;;
                        k++;
                    }else{
                        throw new IllegalArgumentException("Argument does not meet specifications of constructor");
                    }
                }
            }else{
                for(int j=0;j<size;j++){
                    c = val.charAt(j);
                    if(48 <= c && c <= 57){
                        array[k] = c - 48;;
                        k++;
                    }else{
                        throw new IllegalArgumentException("Argument does not meet specifications of constructor");
                    }
                }
            }
        }else{
            throw new IllegalArgumentException("Argument does not meet specifications of constructor");
          }
    }
    
    //add method, fully functional for negative numbers as well, long as its used in subtraction as well so every case must be checked.
    public HugeInteger add(HugeInteger h){
        int carry = 0, i, j=0,temp;
        String val_sum = "0";
        HugeInteger sum = new HugeInteger(val_sum);
        //split into 2 sections if this size is greater than h and if h is greater
        if(size >= h.size){
            //if both are pos then both numbers are simply added
            if(negative == false && h.negative == false){
                val_sum = "";
                j = h.size-1;
                for(i=(size-1);i>=0;i--){
                    if(i>=(size-h.size)){
                        carry = array[i] + h.array[j];
                        j--;
                        if(carry >= 10){
                            if((i-1) != -1){
                                array[i-1] += 1;
                                carry = carry%10;
                            }
                        }
                        val_sum = Integer.toString(carry) + val_sum;
                    }else{
                        val_sum = Integer.toString(this.array[i]) + val_sum;
                    }
                }
                sum = new HugeInteger(val_sum);
                val_sum = "";
                return sum;
            //if both are neg then they can also be simply added however the result will be negative
            }else if(negative==true && h.negative==true){
                val_sum = "";
                j = h.size-1;
                for(i=(size-1);i>=0;i--){
                    if(i>=(size-h.size)){
                        carry = array[i] + h.array[j];
                        j--;
                        if(carry >= 10){
                            if((i-1) != -1){
                                array[i-1] += 1;
                                carry = carry%10;
                            }
                        }
                        val_sum = Integer.toString(carry) + val_sum;
                    }else{
                        val_sum = Integer.toString(this.array[i]) + val_sum;
                    }
                }
                sum = new HugeInteger(val_sum);
                sum.negative=true;
                val_sum = "";
                return sum;
            //if the first is pos and the second one is negative then its basically subtraction 
            }else if(negative==false && h.negative==true){
                val_sum = "";
                j = h.size-1;
                for(i=(size-1);i>=0;i--){
                    if(i>=(size-h.size)){
                        carry = array[i] - h.array[j];
                        j--;
                        if(carry<0){
                            if((i-1) != -1 && array[i-1]>1){
                                array[i-1] -= 1;
                                carry = 10+carry;
                            }else{
                                temp=i;
                                while((temp-1)!=-1 && array[temp-1]==0){
                                    temp--;
                                }
                                array[temp]=9;
                                array[temp-1] -= 1;
                                carry=10+carry;
                            }
                        }
                        val_sum = Integer.toString(carry) + val_sum;
                    }else{
                        val_sum = Integer.toString(this.array[i]) + val_sum;
                    }
                }
                sum = new HugeInteger(val_sum);
                val_sum = "";
                return sum;
            //if the first is neg and second pos then again the operation resembles subtraction
            }else if(negative==true && h.negative==false){
                val_sum = "";
                j = h.size-1;
                for(i=(size-1);i>=0;i--){
                    if(i>=(size-h.size)){
                        carry = array[i] - h.array[j];
                        j--;
                        if(carry<0){
                            if((i-1) != -1 && array[i-1]>1){
                                array[i-1] -= 1;
                                carry = 10+carry;
                            }else{
                                temp=i;
                                while((temp-1)!=-1 && array[temp-1]==0){
                                    temp--;
                                }
                                array[temp]=9;
                                array[temp-1] -= 1;
                                carry=10+carry;
                            }
                        }
                        val_sum = Integer.toString(carry) + val_sum;
                    }else{
                        val_sum = Integer.toString(this.array[i]) + val_sum;
                    }
                }
                sum = new HugeInteger(val_sum);
                sum.negative=true;
                val_sum = "";
                return sum;
            }
        //if h is larger then this is run basically the same code but flipped
        }else{
            //if both are pos then again they are added
            if(negative == false && h.negative == false){
                val_sum = "";
                j = size-1;
                for(i=(h.size-1);i>=0;i--){
                    if(i>=(h.size-size)){
                        carry = h.array[i] + array[j];
                        j--;
                        if(carry >= 10){
                            if((i-1) != -1){
                                h.array[i-1] += 1;
                                carry = carry%10;
                            }
                        }   
                        val_sum = Integer.toString(carry) + val_sum;
                    }else{
                        val_sum = Integer.toString(h.array[i]) + val_sum;
                    }
                }
                sum = new HugeInteger(val_sum);
                val_sum = "";
                return sum;
            //if both are neg then again they are added directly except the result is negative
            }else if(negative == true && h.negative == true){
                val_sum = "";
                j = size-1;
                for(i=(h.size-1);i>=0;i--){
                    if(i>=(h.size-size)){
                        carry = h.array[i] + array[j];
                        j--;
                        if(carry >= 10){
                            if((i-1) != -1){
                                h.array[i-1] += 1;
                                carry = carry%10;
                            }
                        }   
                        val_sum = Integer.toString(carry) + val_sum;
                    }else{
                        val_sum = Integer.toString(h.array[i]) + val_sum;
                    }
                }
                sum = new HugeInteger(val_sum);
                sum.negative=true;
                val_sum = "";
                return sum;
            //if the first is pos and the second is neg then its simple subtraction
            }else if(negative == false && h.negative == true){
                val_sum = "";
                j = size-1;
                for(i=(h.size-1);i>=0;i--){
                    if(i>=(h.size-size)){
                        carry = h.array[i] - array[j];
                        j--;
                        if(carry < 0){
                            if((i-1) != -1 && h.array[i-1]>1){
                                h.array[i-1] -= 1;
                                carry = 10+carry;
                            }else{
                                temp=i;
                                while((temp-1)!=-1 && h.array[temp-1]==0){
                                    temp--;
                                }
                                h.array[temp]=9;
                                h.array[temp-1] -= 1;
                                carry=10+carry;
                            }
                        }   
                        val_sum = Integer.toString(carry) + val_sum;
                    }else{
                        val_sum = Integer.toString(h.array[i]) + val_sum;
                    }
                }
                sum = new HugeInteger(val_sum);
                sum.negative=true;
                val_sum = "";
                return sum;
            //again if they differ in sign we subtract them
            }else if(negative == true && h.negative == false){
                val_sum = "";
                j = size-1;
                for(i=(h.size-1);i>=0;i--){
                    if(i>=(h.size-size)){
                        carry = h.array[i] - array[j];
                        j--;
                        if(carry < 0){
                            if((i-1) != -1 && h.array[i-1]>1){
                                h.array[i-1] -= 1;
                                carry = 10+carry;
                            }else{
                                temp=i;
                                while((temp-1)!=-1 && h.array[temp-1]==0){
                                    temp--;
                                }
                                h.array[temp]=9;
                                h.array[temp-1] -= 1;
                                carry=10+carry;
                            }
                        }   
                        val_sum = Integer.toString(carry) + val_sum;
                    }else{
                        val_sum = Integer.toString(h.array[i]) + val_sum;
                    }
                }
                sum = new HugeInteger(val_sum);
                val_sum = "";
                return sum;
            }
        }
        return sum;
    }
    //subtract method, useing add to make this function really simple
    public HugeInteger subtract(HugeInteger h){
        //creating a new temporary hugeint for use in the method
        HugeInteger sum = new HugeInteger(h.toString());
        //going through each condition and depending on their signs we pass different arguements to add
        if(negative==false && h.negative==false){
            sum.negative=true;
            return (this.add(sum));
        }else if(negative==true && h.negative==true){
            sum.negative=false;
            return this.add(sum);
        }else if(negative==true && h.negative==false){
            sum.negative=true;
            return this.add(sum);
        }else if(negative==false && h.negative==true){
            sum.negative=false;
            return this.add(sum);
        }
        return this;
    }
    //multiply method
    public HugeInteger multiply(HugeInteger h){
        int num = 0;
        int res=0,i,j,temp,pow=0;
        //making the first number into a integer for use in the method
        for(i=0; i<size; i++){
            num*=10;
            num += array[i];
        }
        //if either size is 0 then the result must be 0
        if(size==0 || h.size==0){
            HugeInteger product = new HugeInteger("0");
            return product;
        //same instructions if both pos or both neg
        }else if((negative==false && h.negative==false) || (negative==true && h.negative==true)){
            for(i=h.size-1;i>=0;i--){
                temp=h.array[i];
                for(j=0;j<pow;j++){
                    temp*=10;
                }
                temp*=num;
                res+=temp;
                pow++;
            }
            HugeInteger product = new HugeInteger(Integer.toString(res));
            product.negative=false;
            return product;
        //if they differ then the same process however the final result will be negative
        }else if((negative==true && h.negative==false) || (negative==false && h.negative==true)){
            for(i=h.size-1;i>=0;i--){
                temp=h.array[i];
                for(j=0;j<pow;j++){
                    temp*=10;
                }
                temp*=num;
                res+=temp;
                pow+=1;
            }
            HugeInteger product = new HugeInteger(Integer.toString(res));
            product.negative=true;
            return product;

        }
        HugeInteger product = new HugeInteger(Integer.toString(res));
        return product;
    }
    //compareTo method, checking all conditions for negatives which would give the larger number
    public Integer compareTo(HugeInteger h){
        Integer res = 0;
        if(negative==true && h.negative==false){
            res=-1;
            return res;
        }else if(negative==false && h.negative==true){
            res=1;
            return res;
        //if both have the same sign we need to check them using a different method. either through checking size or iterating through both numbers
        }else if(negative==false && h.negative==false){
            if(size>h.size){
                res=1;
                return res; 
            }else if(size<h.size){
                res=-1;
                return res;
            }else{
                for(int i=0;i<size;i++){
                    if(array[i]<h.array[i]){
                        res=-1;
                        return res;
                    }else if(this.array[i]>h.array[i]){
                        res=1;
                        return res;
                    }
                }
                res=0;
                return res;
            }
        //likewise if they are both negative then we have to use a different algorithm
        }else if(negative==true && h.negative==true){
            if(size<h.size){
                res=1;
                return res; 
            }else if(size>h.size){
                res=-1;
                return res;
            }else{
                for(int i=0;i<size;i++){
                    if(array[i]>h.array[i]){
                        res=-1;
                        return res;
                    }else if(this.array[i]<h.array[i]){
                        res=1;
                        return res;
                    }
                }
                res=0;
                return res;
            }
        }
        return res;
    }
    //ToString method, this method performs all desired output conditions. Removing leading zeroes along with others
    public String toString(){
        int i;
        String output = new String();
        if(size==0){
            output="The list is empty";
            return output;
        }
        for(i=0;i<size;i++){
            output += array[i];
        }
        //removing leading 0s
        output = output.replaceAll("^[0]+", "");
        //if all zeros then the result should only be one zero
        if (output.equals("")){
            return "0";
        }
        //including negative sign if applicable
        if(negative==true){
            output="-" + output.substring(0);
        }
        return output;
    }
    
}
