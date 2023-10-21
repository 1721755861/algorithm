package EE;

import java.util.Scanner;

public class Num {

    public void nume(long n){



//        while(t--)
//        {
//            cin>>num;
//            long long res=0,n=num,t=0;
//            while(n)
//            {
//                int m=n%10;
//                n/=10;
//                if(m==0||num%m==0)
//                    res++;
//                t++;
//            }
//            if(res==0)
//                cout<<"S"<<endl;
//            else if(res==t)
//                cout<<"G"<<endl;
//            else
//                cout<<"H"<<endl;
//        }
    }

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()) {

            //the num of NUM ,for example,3
            int n = Integer.valueOf(sc.nextLine());

            //用数组存起来
            long[] nums = new long[n];
            for (int i = 0; i < n; i++) {
                nums[i] = sc.nextLong();
            }
            for (long i : nums) {
                System.out.println(i);
            }

            //开始对每个数进行计算
            for (int i = 0; i < nums.length; i++) {

                //从第一个数开始算
                while (i < nums.length) {

                    //s:得到这个数的位数
                    int s = 0;
                    long n2 = nums[i];
                    while (true) {
                        if(n2<10){
                            s=1;
                            //break跳出的不是if吧
                            break;
                        }

                        else if (n2 / 10 > 0) {
                            n2 /= 10;
                            s++;
                            System.out.println("duo shao wei shu?"+s);
                        } else {
                            break;
                        }

                        System.out.println("< 10 , cant execute?");
                    }

                    //得到位数，开始计算
                    int res = 0;
                    //计算过程是不断除以各位上的数，所以需要计算s次
                    for (int m = 0; m < s; m++) {
                        //得到每位上的数用的是取余
                        long n3 = nums[i] % 10;

                        //短路或的用法：避免除以0
                        if (n3 == 0||nums[i] % n3 == 0  ) {
                            res++;
                        }
                        nums[i] /= 10;
                    }
                    i++;


                    if (res == 0)
                        System.out.println("S");
                    else if (res < s)
                        System.out.println("H");
                    else if (res == s)
                        System.out.println("G");

                }


            }

        }


    }



}
