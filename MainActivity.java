package com.example.ahuntsic.mobile.calculatrice;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    String resultat="", expression="",nombreEntre="";
    boolean activerPriorite = false, activerDiviseur = false, activerPlus = false,
            activerMoins=false;
    int present;
    double cumulatif = 0, autreNombre, multipliant, quotient, numerateur,
            operationRacine;
    Button back, CE, C, plusMoins, racine, sept, huit,
        neuf, diviser, pourcentage, quatre, cinq, six,
        multiplier, inverse, un, deux, trois, moins,egale,
        zero, virgule, plus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        back = (Button) findViewById(R.id.btBack);
        CE = (Button) findViewById(R.id.btCE);
        C = (Button) findViewById(R.id.btC);
        plusMoins = (Button) findViewById(R.id.btPlusMoins);
        racine = (Button) findViewById(R.id.btRacine);
        sept = (Button) findViewById(R.id.bt7);
        huit = (Button) findViewById(R.id.bt8);
        neuf = (Button) findViewById(R.id.bt9);
        diviser = (Button) findViewById(R.id.btDiviser);
        pourcentage = (Button) findViewById(R.id.btPourcentage);
        quatre = (Button) findViewById(R.id.bt4);
        cinq = (Button) findViewById(R.id.bt5);
        six = (Button) findViewById(R.id.bt6);
        multiplier = (Button) findViewById(R.id.btMultiplier);
        inverse = (Button) findViewById(R.id.btInverser);
        un = (Button) findViewById(R.id.bt1);
        deux = (Button) findViewById(R.id.bt2);
        trois = (Button) findViewById(R.id.bt3);
        moins = (Button) findViewById(R.id.btMoins);
        egale = (Button) findViewById(R.id.btEgale);
        zero = (Button) findViewById(R.id.bt0);
        virgule = (Button) findViewById(R.id.btVirgule);
        plus = (Button) findViewById(R.id.btPlus);

        back.setOnClickListener(this);
        CE.setOnClickListener(this);
        C.setOnClickListener(this);
        plusMoins.setOnClickListener(this);
        racine.setOnClickListener(this);
        sept.setOnClickListener(this);
        huit.setOnClickListener(this);
        neuf.setOnClickListener(this);
        diviser.setOnClickListener(this);
        pourcentage.setOnClickListener(this);
        quatre.setOnClickListener(this);
        cinq.setOnClickListener(this);
        six.setOnClickListener(this);
        multiplier.setOnClickListener(this);
        inverse.setOnClickListener(this);
        un.setOnClickListener(this);
        deux.setOnClickListener(this);
        trois.setOnClickListener(this);
        moins.setOnClickListener(this);
        egale.setOnClickListener(this);
        zero.setOnClickListener(this);
        virgule.setOnClickListener(this);
        plus.setOnClickListener(this);
    }

        public void onClick(View v) {
            switch(v.getId()) {
                case R.id.btBack:
                    int longueur= resultat.length();
                    if (longueur > 0) {
                    //   resultat.delete(longueur - 1, longueur);
                    }
                    ((TextView) findViewById(R.id.viewResultat)).setText(resultat);
                    break;
                case R.id.btCE:
                    nombreEntre= "";
                    ((TextView) findViewById(R.id.viewResultat)).setText("0");
                    ((TextView) findViewById(R.id.viewCalculs)).setText(expression);
                    break;
                case R.id.btC:
                    initialiser();
                    break;
                case R.id.btPlusMoins:
                    if (nombreEntre.equalsIgnoreCase("")){
                        present = resultat.indexOf('-');
                        if (present >= 0){
                            resultat = resultat.substring(1);
                        }
                        else{
                            resultat = "-" + resultat;
                        }
                    }
                    else {
                        present = nombreEntre.indexOf('-');
                        if (present >= 0){
                            nombreEntre = nombreEntre.substring(1);
                            resultat = nombreEntre;
                        }
                        else{
                            nombreEntre = "-" + nombreEntre;
                            resultat = nombreEntre;
                        }
                    }
                    ((TextView) findViewById(R.id.viewResultat)).setText(resultat);
                    break;
                case R.id.btRacine:
                    if (nombreEntre.equalsIgnoreCase("")){
                        operationRacine = Double.parseDouble(resultat);
                        if (operationRacine <=0){
                            ((TextView) findViewById(R.id.viewResultat)).setText("Erreur!");
                        }
                        else{
                            resultat = Math.sqrt(Double.parseDouble(resultat)) + "" ;
                        }
                    }
                    else{
                        operationRacine = Double.parseDouble(nombreEntre);
                        if (operationRacine <=0){
                            ((TextView) findViewById(R.id.viewResultat)).setText("Erreur!");
                        }
                        else {
                            nombreEntre = Math.sqrt(Double.parseDouble(nombreEntre)) + "" ;
                            expression += nombreEntre;
                            resultat = nombreEntre;
                            ((TextView) findViewById(R.id.viewCalculs)).setText(expression);
                        }
                    }
                    ((TextView) findViewById(R.id.viewResultat)).setText(resultat);
                    nombreEntre = "";
                    break;
                case R.id.btInverser:
                    if (nombreEntre.equalsIgnoreCase("")){
                        if(Double.parseDouble(resultat)==0){
                            ((TextView) findViewById(R.id.viewResultat)).setText("Erreur!");
                        }else{
                            resultat  =  (1/Double.parseDouble(resultat))+"" ;
                        }
                    }else{
                        if(Double.parseDouble(nombreEntre)==0){
                            ((TextView) findViewById(R.id.viewResultat)).setText("Erreur!");
                        }else{
                            nombreEntre  =  (1/Double.parseDouble(nombreEntre))+"" ;
                            nombreEntre = resultat;
                        }
                    }
                    ((TextView) findViewById(R.id.viewResultat)).setText(resultat);
                    break;
                case R.id.bt7:
                    expression+= "7";
                    nombreEntre+= "7";
                    ((TextView) findViewById(R.id.viewResultat)).setText(nombreEntre);
                    break;
                case R.id.bt8:
                    expression+= "8";
                    nombreEntre+= "8";
                    ((TextView) findViewById(R.id.viewResultat)).setText(nombreEntre);
                    break;
                case R.id.bt9:
                    expression+= "9";
                    nombreEntre+= "9";
                    ((TextView) findViewById(R.id.viewResultat)).setText(nombreEntre);
                    break;
                case R.id.btDiviser:
                    autreNombre = Double.parseDouble(nombreEntre);
                    nombreEntre = "";
                    expression+= "/";
                    if (activerDiviseur==true){
                        quotient = numerateur/autreNombre;
                        numerateur = quotient;
                        resultat= quotient + "";
                    }
                    if (activerPriorite==true){
                        activerPriorite = false;
                        numerateur = multipliant * autreNombre;
                        resultat = numerateur+"";
                    }
                    else{
                        numerateur = autreNombre;
                    }
                    activerDiviseur = true;
                    ((TextView) findViewById(R.id.viewCalculs)).setText(expression);
                    ((TextView) findViewById(R.id.viewResultat)).setText(resultat);
                    break;
                case R.id.btPourcentage:
                    present = resultat.indexOf('%');
                    if (present >= 0){

                    }
                    else{
                        if (nombreEntre.equalsIgnoreCase("")){
                            resultat = (Double.parseDouble(resultat)/100+"");
                        }else{
                            resultat = (Double.parseDouble(nombreEntre)/100+"");
                        }

                    }
                    expression += resultat;
                    ((TextView) findViewById(R.id.viewCalculs)).setText(expression);
                    ((TextView) findViewById(R.id.viewResultat)).setText(resultat);
                    nombreEntre = "";
                    break;
                case R.id.bt4:
                    expression+= "4";
                    nombreEntre+= "4";
                    ((TextView) findViewById(R.id.viewResultat)).setText(nombreEntre);
                    break;
                case R.id.bt5:
                    expression+= "5";
                    nombreEntre+= "5";
                    ((TextView) findViewById(R.id.viewResultat)).setText(nombreEntre);
                    break;
                case R.id.bt6:
                    expression+= "6";
                    nombreEntre+= "6";
                    ((TextView) findViewById(R.id.viewResultat)).setText(nombreEntre);
                    break;
                case R.id.btMultiplier:
                    autreNombre = Double.parseDouble(nombreEntre);
                    nombreEntre = "";
                    expression+= "*";
                    if (activerDiviseur == true){
                        activerDiviseur = false;
                        multipliant = numerateur / autreNombre;
                    }
                    if (activerPriorite == true){
                        multipliant = multipliant * autreNombre;
                    }
                    else{
                        multipliant = autreNombre;
                    }
                    resultat=multipliant+"";
                    activerPriorite = true;
                    ((TextView) findViewById(R.id.viewCalculs)).setText(expression);
                    ((TextView) findViewById(R.id.viewResultat)).setText(resultat);
                    break;
                case R.id.bt1:
                    expression+= "1";
                    nombreEntre+= "1";
                    ((TextView) findViewById(R.id.viewResultat)).setText(nombreEntre);
                    break;
                case R.id.bt2:
                    expression+= "2";
                    nombreEntre+= "2";
                    ((TextView) findViewById(R.id.viewResultat)).setText(nombreEntre);
                    break;
                case R.id.bt3:
                    expression+= "3";
                    nombreEntre+= "3";
                    ((TextView) findViewById(R.id.viewResultat)).setText(nombreEntre);
                    break;
                case R.id.btMoins:
                    autreNombre = Double.parseDouble(nombreEntre);
                    nombreEntre = "";
                    expression += "-";
                    if (activerPriorite ==true && activerMoins==true){
                        multipliant = autreNombre * multipliant;
                        cumulatif -= multipliant;
                        resultat = cumulatif+ "";
                        activerPriorite = false;
                    }
                    else if (activerPriorite ==true){
                    multipliant = autreNombre * multipliant;
                    cumulatif += multipliant;
                    resultat = cumulatif+ "";
                    activerPriorite = false;
                }
                    else if (activerDiviseur==true){
                        quotient = numerateur/autreNombre;
                        resultat = quotient + cumulatif +"";
                        cumulatif += quotient;
                        activerDiviseur=false;
                    }
                    else if (activerPlus==true){
                        cumulatif += autreNombre;
                        resultat = cumulatif+"";
                        activerPlus = false;
                    }
                    else{
                        cumulatif -= autreNombre;
                        resultat = cumulatif+"";
                    }
                    activerMoins=true;
                    ((TextView) findViewById(R.id.viewCalculs)).setText(expression);
                    ((TextView) findViewById(R.id.viewResultat)).setText(resultat);
                    break;
                case R.id.bt0:
                    if (nombreEntre.equalsIgnoreCase("")){

                    }else{
                        nombreEntre+= "0";
                        expression+= "0";
                    }
                    ((TextView) findViewById(R.id.viewResultat)).setText(nombreEntre);
                    break;
                case R.id.btVirgule:
                    if (nombreEntre.equalsIgnoreCase("")){

                    }else{
                        nombreEntre+= ".";
                        expression+= ".";
                    }
                    ((TextView) findViewById(R.id.viewResultat)).setText(nombreEntre);
                    break;
                case R.id.btPlus:
                    autreNombre = Double.parseDouble(nombreEntre);
                    expression+= "+";
                    if (activerPriorite == true && activerMoins == true) {
                        multipliant *= autreNombre;
                        cumulatif -= multipliant;
                        resultat = cumulatif + "";
                        activerPriorite = false;
                    }
                    else if (activerPriorite == true){
                        multipliant *= autreNombre;
                        cumulatif += multipliant;
                        resultat = cumulatif+ "";
                        activerPriorite = false;
                    }
                    else if (activerDiviseur==true && activerMoins==true){
                        quotient = numerateur/autreNombre;
                        cumulatif -= quotient;
                        resultat = cumulatif +"";
                        activerDiviseur=false;
                    }
                    else if (activerDiviseur==true){
                        quotient = numerateur/autreNombre;
                        cumulatif += quotient;
                        resultat = cumulatif +"";
                        activerDiviseur=false;
                    }
                    else if (activerMoins==true){
                        activerMoins= false;
                        cumulatif -= autreNombre;
                        resultat = cumulatif+"";
                    }
                    else{
                        cumulatif += autreNombre;
                        resultat = cumulatif+"";
                    }
                    activerPlus = true;
                    ((TextView) findViewById(R.id.viewCalculs)).setText(expression);
                    ((TextView) findViewById(R.id.viewResultat)).setText(resultat);
                    nombreEntre = "";
                    break;
                case R.id.btEgale:
                    autreNombre = Double.parseDouble(nombreEntre);
                    nombreEntre = "";
                    expression+= "=";
                    if (activerPlus == true){
                        cumulatif += autreNombre;
                        resultat = cumulatif+"";
                        activerPlus=false;
                    }
                    else if (activerMoins==true){
                        cumulatif -= autreNombre;
                        resultat = cumulatif+"";
                        activerMoins=false;
                    }
                    else if (activerPriorite==true && activerMoins == true){
                        multipliant *= autreNombre;
                        cumulatif -= multipliant;
                        resultat = cumulatif+ "";
                        activerPriorite=false;
                    }
                    else if (activerPriorite==true){
                        multipliant *= autreNombre;
                        cumulatif += multipliant;
                        resultat = cumulatif+ "";
                        activerPriorite=false;
                    }
                    else if (activerDiviseur=true && activerMoins==true){
                        quotient = numerateur/autreNombre;
                        cumulatif -= quotient;
                        resultat = cumulatif +"";
                        activerDiviseur=false;
                    }
                    else if (activerDiviseur=true){
                        quotient = numerateur/autreNombre;
                        resultat = quotient + cumulatif +"";
                        activerDiviseur=false;
                    }
                    else{
                        resultat = "Erreur";
                    }
                    ((TextView) findViewById(R.id.viewCalculs)).setText(expression);
                    ((TextView) findViewById(R.id.viewResultat)).setText(resultat);
                    expression="";
                    nombreEntre= "";
                    cumulatif = 0;
                    activerDiviseur= false;
                    activerMoins= false;
                    activerPlus= false;
                    activerPriorite=false;
                    break;
            }
        }

    public void initialiser(){
        resultat="";
        expression="";
        nombreEntre= "";
        cumulatif = 0;
        activerDiviseur= false;
        activerMoins= false;
        activerPlus= false;
        activerPriorite=false;
        ((TextView) findViewById(R.id.viewResultat)).setText(resultat);
        ((TextView) findViewById(R.id.viewCalculs)).setText(expression);
    }

}
