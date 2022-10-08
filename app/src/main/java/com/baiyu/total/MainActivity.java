package com.baiyu.total;

import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    List<CheckBox> checkBoxSum;//记录商品 清空用的  也就是购物车


    CheckBox checkBox1;//汉堡
    CheckBox checkBox2;//可乐

    CheckBox checkBox3;//鸡翅

    CheckBox checkBox4;//薯条



    Button payButton;
    Button clearButton;//清空



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        checkBoxSum=new ArrayList<>();

        checkBox1=findViewById(R.id.apple);
        checkBox2=findViewById(R.id.watermalen);
        checkBox3=findViewById(R.id.jichi);
        checkBox4=findViewById(R.id.shutiao);


        payButton=findViewById(R.id.pay);
        clearButton=findViewById(R.id.clear);

        payButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                jieZhang();
            }
        });



        clearButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                for (CheckBox cb: checkBoxSum) {

                    cb.setChecked(false);
                }
            }
        });





    }



    private void jieZhang() {
        int sum=0;
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(this)
                .setTitle("账单:")
                ;

        String str="";
        if(checkBox1.isChecked()){

            str =str+ "商品:汉堡 价格:1元\n";
            sum=sum+1;
            checkBoxSum.add(checkBox1);
        }

        if(checkBox2.isChecked()){

            str=str + "商品:可乐 价格:2元\n";

            sum=sum+2;
            checkBoxSum.add(checkBox2);
        }

        if(checkBox3.isChecked()){
            str=str + "商品:鸡翅 价格:3元\n";

            sum=sum+3;
            checkBoxSum.add(checkBox3);

        }

        if (checkBox4.isChecked()) {
            str=str + "商品:薯条 价格:4元\n";

            sum=sum+4;

            checkBoxSum.add(checkBox4);
        }



        String str99="总价格"+sum+"\n";

        str=str+str99;

        alertDialog.setMessage(str);
        alertDialog.create();
        alertDialog.show();




    }
}