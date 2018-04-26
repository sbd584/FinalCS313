import ddf.minim.*;
import ddf.minim.analysis.*;
import ddf.minim.effects.*;
import ddf.minim.signals.*;
import ddf.minim.spi.*;
import ddf.minim.ugens.*;

Minim minim;
Middle_key mk1,mk2,mk3,mk4,mk5,mk6,mk7,mk8,mk9,mk10,mk11,mk12,mk13;
Middle_key mk_1,mk_2,mk_3,mk_4,mk_5,mk_6,mk_7,mk_8,mk_9,mk_10,mk_11,mk_12,mk_13;
int mk1Click = 0;
int mk2Click = 0;
int mk3Click = 0;
int mk4Click = 0;
int mk5Click = 0;
int mk6Click = 0;
int mk7Click = 0;
int mk8Click = 0;
int mk9Click = 0;
int mk10Click = 0;
int mk11Click = 0;
int mk12Click = 0;
int mk13Click = 0;
int l1Click = 0;
int l2Click = 0;
int l3Click = 0;
int l4Click = 0;
int l5Click = 0;
int l6Click = 0;
int top1Click = 0;
int top2Click = 0;
int top3Click = 0;
int top4Click = 0;
int top5Click = 0;
int top6Click = 0;
int top7Click = 0;
int top8Click = 0;
int top9Click = 0;
int top10Click = 0;
int top11Click = 0;
int top12Click = 0;
int top13Click = 0;
int clickCount = 0;
float waveN = 0;
float mute = 0;
float record = 0;
float record_dot = 0;
float stop = 0;
float play = 0;
float GUI_change = 2;
PFont font;
String string1 = " Hello and Welcome ";
String string2 = " Click To Continue ";
int gui2Timer;
int gui2Timer2;
int gui2TimerCycle;
int textWidth;

AudioSample keyNote;
String keyName;
ArrayList<AudioSample> keys;
void setup() {
  size(1800, 1000);
  minim = new Minim(this);
  
  //Minim stuff
  keys = new ArrayList<AudioSample>();
  for(int i=0;i<32;i++){
    keyName = "jobro__piano-ff-088 (" + nf(i+1 + 32) + ").wav";
    keyNote = minim.loadSample(keyName,512);
    keys.add(keyNote);
  }
  // GUI 2
  // Middle_keys
  
  mk1 = new Middle_key(150,450,0);
  mk2 = new Middle_key(250,450,1);
  mk3 = new Middle_key(400,450,0);
  mk4 = new Middle_key(500,450,1);
  mk5 = new Middle_key(600,450,0);
  mk6 = new Middle_key(750,450,1);
  mk7 = new Middle_key(850,450,0);
  mk8 = new Middle_key(1000,450,1);
  mk9 = new Middle_key(1100,450,0);
  mk10 = new Middle_key(1200,450,1);
  mk11 = new Middle_key(1350,450,0);
  mk12 = new Middle_key(1450,450,1);
  mk13 = new Middle_key(1600,450,0);

  // Button Pressed
  mk_1 = new Middle_key(150,450,2);
  mk_2 = new Middle_key(250,450,2);
  mk_3 = new Middle_key(400,450,2);
  mk_4 = new Middle_key(500,450,2);
  mk_5 = new Middle_key(600,450,2);
  mk_6 = new Middle_key(750,450,2);
  mk_7 = new Middle_key(850,450,2);
  mk_8 = new Middle_key(1000,450,2);
  mk_9 = new Middle_key(1100,450,2);
  mk_10 = new Middle_key(1200,450,2);
  mk_11 = new Middle_key(1350,450,2);
  mk_12 = new Middle_key(1450,450,2);
  mk_13 = new Middle_key(1600,450,2);
}

void draw() {
  if(GUI_change == 1){
    background(0);
    fill(300,200,200);
    rect(50, 50, 1700, 900,20);
    font = loadFont("Chalkboard-Bold-24.vlw");
    textFont(font, 24);
    textSize(100);
    fill(0, 102, 153);
    gui2Timer += 1;
    gui2Timer2 += 1;
    gui2TimerCycle += 0;
    int string_char = int(gui2Timer/5);
    int height1 = 200;
    int center1 = 575;
    int rate1 = 100;
// int(gui2Timer/20)
    if (string1.length() > string_char){
      for (int i = 0; i < min(string1.length(),string_char); i += 1){

        if (i > 5){
          height1 = 400;
          center1 = 75;
        }
        if (i > 10){
          height1 = 600;
          center1 = -500;
        }
        textSize(100);
        text(string1.substring(i,i+1),center1 +(i*rate1),height1);
      }
    }
    if (string1.length() < string_char){
      gui2Timer = 0;
      gui2TimerCycle += 1;
    }
    if (gui2TimerCycle > 0){

      text(string2,500,900);

    }

  }


  if(GUI_change == 2){
    noStroke();
    fill(50);
    rect(50, 50, 1700, 900,20);
    // Play
    fill(play);
    ellipse(125, 110, 75, 75);

    // Stop
    fill(stop);
    ellipse(200, 110, 75, 75);

    // Record
    fill(record);
    ellipse(315, 120, 100, 100);
    fill(record_dot,0,0);
    ellipse(315, 120, 30, 30);

    // Mute
    fill(mute);
    ellipse(1600, 140, 125, 125);

    // Extra Screen: Maybe for the beat??
    fill(0,237,30);
    rect(200, 225, 1400, 200);


    // Keyboard
    fill(255);
    rect(100, 450, 1600, 500);
    // Middle and right keys
    mk1.display();
    mk2.display();
    mk3.display();
    mk4.display();
    mk5.display();
    mk6.display();
    mk7.display();
    mk8.display();
    mk9.display();
    mk10.display();
    mk11.display();
    mk12.display();
    mk13.display();
    // Left keys
    fill(300,200,200);
    rect(100,450,50,500);
    if(l1Click == 1){
      if(clickCount <= 10){
        fill(0);
        rect(100,450,50,500);
        clickCount += 1;
      }
      else{
        clickCount = 0;
        l1Click = 0;
        keys.get(0).trigger();
      }
      waveN = 14;
    }
    fill(300,200,200);
    rect(350,450,50,500);
    if(l2Click == 1){
      if(clickCount <= 10){
        fill(0);
        rect(350,450,50,500);
        clickCount += 1;
      }
      else{
        clickCount = 0;
        l2Click = 0;
        keys.get(5).trigger();
      }
      waveN = 15;
    }
    fill(300,200,200);
    rect(700,450,50,500);
    if(l3Click == 1){
      if(clickCount <= 10){
        fill(0);
        rect(700,450,50,500);
        clickCount += 1;
      }
      else{
        clickCount = 0;
        l3Click = 0;
        keys.get(12).trigger();
      }
      waveN = 16;
    }
    fill(300,200,200);
    rect(950,450,50,500);
    if(l4Click == 1){
      if(clickCount <= 10){
        fill(0);
        rect(950,450,50,500);
        clickCount += 1;
      }
      else{
        clickCount = 0;
        l4Click = 0;
        keys.get(17).trigger();
      }
      waveN = 17;
    }
    fill(300,200,200);
    rect(1300,450,50,500);
    if(l5Click == 1){
      if(clickCount <= 10){
        fill(0);
        rect(1300,450,50,500);
        clickCount += 1;
      }
      else{
        clickCount = 0;
        l5Click = 0;
        
        keys.get(24).trigger();
      }
      waveN = 18;
    }
    fill(300,200,200);
    rect(1550,450,50,500);
    if(l6Click == 1){
      if(clickCount <= 10){
        fill(0);
        rect(1550,450,50,500);
        clickCount += 1;
      }
      else{
        clickCount = 0;
        l6Click = 0;
        keys.get(29).trigger();
      }
      waveN = 19;
    }

    // White pieces
    if(top1Click == 1){
      if(clickCount <= 10){
        fill(0);
        rect(150,450,50,300);
        clickCount += 1;
      }
      else{
        clickCount = 0;
        top1Click = 0;
        
        keys.get(1).trigger();
      }
      waveN = 20;
    }
    if(top2Click == 1){
      if(clickCount <= 10){
        fill(0);
        rect(250,450,50,300);
        clickCount += 1;
      }
      else{
        clickCount = 0;
        top2Click = 0;
        
        keys.get(3).trigger();
      }
      waveN = 21;
    }
    if(top3Click == 1){
      if(clickCount <= 10){
        fill(0);
        rect(400,450,50,300);
        clickCount += 1;
      }
      else{
        clickCount = 0;
        top3Click = 0;
        
        keys.get(6).trigger();
      }
      waveN = 22;
    }
    if(top4Click == 1){
      if(clickCount <= 10){
        fill(0);
        rect(500,450,50,300);
        clickCount += 1;
      }
      else{
        clickCount = 0;
        top4Click = 0;
        
        keys.get(8).trigger();
      }
      waveN = 23;
    }
    if(top5Click == 1){
      if(clickCount <= 10){
        fill(0);
        rect(600,450,50,300);
        clickCount += 1;
      }
      else{
        clickCount = 0;
        top5Click = 0;
        
        keys.get(10).trigger();
      }
      waveN = 24;
    }
    if(top6Click == 1){
      if(clickCount <= 10){
        fill(0);
        rect(750,450,50,300);
        clickCount += 1;
      }
      else{
        clickCount = 0;
        top6Click = 0;
        
        keys.get(13).trigger();
      }
      waveN = 25;
    }
    if(top7Click == 1){
      if(clickCount <= 10){
        fill(0);
        rect(850,450,50,300);
        clickCount += 1;
      }
      else{
        clickCount = 0;
        top7Click = 0;
        
        keys.get(15).trigger();
      }
      waveN = 26;
    }
    if(top8Click == 1){
      if(clickCount <= 10){
        fill(0);
        rect(1000,450,50,300);
        clickCount += 1;
      }
      else{
        clickCount = 0;
        top8Click = 0;
        
        keys.get(18).trigger();
      }
      waveN = 27;
    }
    if(top9Click == 1){
      if(clickCount <= 10){
        fill(0);
        rect(1100,450,50,300);
        clickCount += 1;
      }
      else{
        clickCount = 0;
        top9Click = 0;
        
        keys.get(20).trigger();
      }
      waveN = 28;
    }
    if(top10Click == 1){
      if(clickCount <= 10){
        fill(0);
        rect(1200,450,50,300);
        clickCount += 1;
      }
      else{
        clickCount = 0;
        top10Click = 0;
        
        keys.get(22).trigger();
      }
      waveN = 29;
    }
    if(top11Click == 1){
      if(clickCount <= 10){
        fill(0);
        rect(1350,450,50,300);
        clickCount += 1;
      }
      else{
        clickCount = 0;
        top11Click = 0;
        
        keys.get(25).trigger();
      }
      waveN = 30;
    }
    if(top12Click == 1){
      if(clickCount <= 10){
        fill(0);
        rect(1450,450,50,300);
        clickCount += 1;
      }
      else{
        clickCount = 0;
        top12Click = 0;
        
        keys.get(27).trigger();
      }
      waveN = 31;
    }
    if(top13Click == 1){
      if(clickCount <= 10){
        fill(0);
        rect(1600,450,50,300);
        clickCount += 1;
      }
      else{
        clickCount = 0;
        top13Click = 0;
        
        keys.get(30).trigger();
      }
      waveN = 32;
    }


    // Button Pressed
    // mk1
    if(mk1Click == 1){
      if(clickCount <= 10){
        mk_1.display();
        clickCount += 1;
      }
      else{
        clickCount = 0;
        mk1Click = 0;
        
        keys.get(2).trigger();
      }
      waveN = 1;
    }
    // mk2
    if(mk2Click == 1){
      if(clickCount <= 10){
        mk_2.display();
        clickCount += 1;
      }
      else{
        clickCount = 0;
        mk2Click = 0;
        
        keys.get(4).trigger();
      }
      waveN = 2;
    }
    // mk3
    if(mk3Click == 1){
      if(clickCount <= 10){
        mk_3.display();
        clickCount += 1;
      }
      else{
        clickCount = 0;
        mk3Click = 0;
        
        keys.get(7).trigger();
      }
      waveN = 3;
    }
    // mk4
    if(mk4Click == 1){
      if(clickCount <= 10){
        mk_4.display();
        clickCount += 1;
      }
      else{
        clickCount = 0;
        mk4Click = 0;
        
        keys.get(9).trigger();
      }
      waveN = 4;
    }
    // mk5
    if(mk5Click == 1){
      if(clickCount <= 10){
        mk_5.display();
        clickCount += 1;
      }
      else{
        clickCount = 0;
        mk5Click = 0;
        
        keys.get(11).trigger();
      }
      waveN = 5;
    }
    // mk6
    if(mk6Click == 1){
      if(clickCount <= 10){
        mk_6.display();
        clickCount += 1;
      }
      else{
        clickCount = 0;
        mk6Click = 0;
        
        keys.get(14).trigger();
      }
      waveN = 6;
    }
    // mk7
    if(mk7Click == 1){
      if(clickCount <= 10){
        mk_7.display();
        clickCount += 1;
      }
      else{
        clickCount = 0;
        mk7Click = 0;
        
        keys.get(16).trigger();
      }
      waveN = 7;
    }
    // mk8
    if(mk8Click == 1){
      if(clickCount <= 10){
        mk_8.display();
        clickCount += 1;
      }
      else{
        clickCount = 0;
        mk8Click = 0;
        
        keys.get(19).trigger();
      }
      waveN = 8;
    }
    // mk9
    if(mk9Click == 1){
      if(clickCount <= 10){
        mk_9.display();
        clickCount += 1;
      }
      else{
        clickCount = 0;
        mk9Click = 0;
        
        keys.get(21).trigger();
      }
      waveN = 9;
    }
    // mk10
    if(mk10Click == 1){
      if(clickCount <= 10){
        mk_10.display();
        clickCount += 1;
      }
      else{
        clickCount = 0;
        mk10Click = 0;
        
        keys.get(23).trigger();
      }
      waveN = 10;
    }
    // mk11
    if(mk11Click == 1){
      if(clickCount <= 10){
        mk_11.display();
        clickCount += 1;
      }
      else{
        clickCount = 0;
        mk11Click = 0;
        
        keys.get(26).trigger();
      }
      waveN = 11;
    }
    // mk12
    if(mk12Click == 1){
      if(clickCount <= 10){
        mk_12.display();
        clickCount += 1;
      }
      else{
        clickCount = 0;
        mk12Click = 0;
        
        keys.get(28).trigger();
      }
      waveN = 12;
    }
    // mk13
    if(mk13Click == 1){
      if(clickCount <= 10){
        mk_13.display();
        clickCount += 1;
      }
      else{
        clickCount = 0;
        mk13Click = 0;
        
        keys.get(31).trigger();
      }
      waveN = 13;
    }
  }
}

void mouseClicked() {
  // Record
  if(dist (315,120,mouseX,mouseY) <= 50){
    if (record_dot < 255 ) {
      record = 0;
      record_dot = 255;
      // 50
    }
    else {
      record = 0;
      record_dot = 0;
    }
  }
  // Mute
  if(dist (1600,140,mouseX,mouseY) <= (125/2)){
    if (mute == 0 ) {
      mute = 105;
    }
    else {
      mute = 0;
    }
  }

  // Stop
  if(dist (200,110,mouseX,mouseY) <= (75/2)){
        if (stop == 0 ) {
      stop = 145;
    }
    else {
      stop = 0;
    }
  }

  //Play
  if(dist (125,110,mouseX,mouseY) <= (75/2)){
        if (play == 0 ) {
      play = 90;
    }
    else {
      play = 0;
    }
  }
  // Gui2
  if(gui2Timer2 > gui2Timer){
    GUI_change = 2;
  }

  // mk1
  if((mouseX >= 50+150 && mouseX <= 100+150 && mouseY >= 450  && mouseY <= 750)||(mouseX >= 150 && mouseX <= 100+150 && mouseY >= 750 && mouseY <= 950)){
    if (mk1Click == 0){
      mk1Click = 1;
    }
    else {
      mk1Click = 0;
    }
  }
  // mk2
  if((mouseX >= 50+250 && mouseX <= 100+250 && mouseY >= 450  && mouseY <= 750)||(mouseX >= 250 && mouseX <= 100+250 && mouseY >= 750 && mouseY <= 950)){
    if (mk2Click == 0){
      mk2Click = 1;
    }
    else {
      mk2Click = 0;
    }
  }
  // mk3
  if((mouseX >= 50+400 && mouseX <= 100+400 && mouseY >= 450  && mouseY <= 750)||(mouseX >= 400 && mouseX <= 100+400 && mouseY >= 750 && mouseY <= 950)){
    if (mk3Click == 0){
      mk3Click = 1;
    }
    else {
      mk3Click = 0;
    }
  }
  // mk4
  if((mouseX >= 50+500 && mouseX <= 100+500 && mouseY >= 450  && mouseY <= 750)||(mouseX >= 500 && mouseX <= 100+500 && mouseY >= 750 && mouseY <= 950)){
    if (mk4Click == 0){
      mk4Click = 1;
    }
    else {
      mk4Click = 0;
    }
  }
  // mk5
  if((mouseX >= 50+600 && mouseX <= 100+600 && mouseY >= 450  && mouseY <= 750)||(mouseX >= 600 && mouseX <= 100+600 && mouseY >= 750 && mouseY <= 950)){
    if (mk5Click == 0){
      mk5Click = 1;
    }
    else {
      mk5Click = 0;
    }
  }
  // mk6
  if((mouseX >= 50+750 && mouseX <= 100+750 && mouseY >= 450  && mouseY <= 750)||(mouseX >= 750 && mouseX <= 100+750 && mouseY >= 750 && mouseY <= 950)){
    if (mk6Click == 0){
      mk6Click = 1;
    }
    else {
      mk6Click = 0;
    }
  }
  // mk7
  if((mouseX >= 50+850 && mouseX <= 100+850 && mouseY >= 450  && mouseY <= 750)||(mouseX >= 850 && mouseX <= 100+850 && mouseY >= 750 && mouseY <= 950)){
    if (mk7Click == 0){
      mk7Click = 1;
    }
    else {
      mk7Click = 0;
    }
  }
  // mk8
  if((mouseX >= 50+1000 && mouseX <= 100+1000 && mouseY >= 450  && mouseY <= 750)||(mouseX >= 1000 && mouseX <= 100+1000 && mouseY >= 750 && mouseY <= 950)){
    if (mk8Click == 0){
      mk8Click = 1;
    }
    else {
      mk8Click = 0;
    }
  }
  // mk9
  if((mouseX >= 50+1100 && mouseX <= 100+1100 && mouseY >= 450  && mouseY <= 750)||(mouseX >= 1100 && mouseX <= 100+1100 && mouseY >= 750 && mouseY <= 950)){
    if (mk9Click == 0){
      mk9Click = 1;
    }
    else {
      mk9Click = 0;
    }
  }
  // mk10
  if((mouseX >= 50+1200 && mouseX <= 100+1200 && mouseY >= 450  && mouseY <= 750)||(mouseX >= 1200 && mouseX <= 100+1200 && mouseY >= 750 && mouseY <= 950)){
    if (mk10Click == 0){
      mk10Click = 1;
    }
    else {
      mk10Click = 0;
    }
  }
  // mk11
  if((mouseX >= 50+1350 && mouseX <= 100+1350 && mouseY >= 450  && mouseY <= 750)||(mouseX >= 1350 && mouseX <= 100+1350 && mouseY >= 750 && mouseY <= 950)){
    if (mk11Click == 0){
      mk11Click = 1;
    }
    else {
      mk11Click = 0;
    }
  }
  // mk12
  if((mouseX >= 50+1450 && mouseX <= 100+1450 && mouseY >= 450  && mouseY <= 750)||(mouseX >= 1450 && mouseX <= 100+1450 && mouseY >= 750 && mouseY <= 950)){
    if (mk12Click == 0){
      mk12Click = 1;
    }
    else {
      mk12Click = 0;
    }
  }
  // mk13
  if((mouseX >= 50+1600 && mouseX <= 100+1600 && mouseY >= 450  && mouseY <= 750)||(mouseX >= 1600 && mouseX <= 100+1600 && mouseY >= 750 && mouseY <= 950)){
    if (mk13Click == 0){
      mk13Click = 1;
    }
    else {
      mk13Click = 0;
    }
  }

  // l1
  if(mouseX >= 100 && mouseX <= 50+100 && mouseY >= 450  && mouseY <= 950){
    if (l1Click == 0){
      l1Click = 1;
    }
    else {
      l1Click = 0;
    }
  }
  if(mouseX >= 350 && mouseX <= 50+350 && mouseY >= 450  && mouseY <= 950){
    if (l2Click == 0){
      l2Click = 1;
    }
    else {
      l2Click = 0;
    }
  }
  if(mouseX >= 700 && mouseX <= 50+700 && mouseY >= 450  && mouseY <= 950){
    if (l3Click == 0){
      l3Click = 1;
    }
    else {
      l3Click = 0;
    }
  }
  if(mouseX >= 950 && mouseX <= 50+950 && mouseY >= 450  && mouseY <= 950){
    if (l4Click == 0){
      l4Click = 1;
    }
    else {
      l4Click = 0;
    }
  }
  if(mouseX >= 1300 && mouseX <= 50+1300 && mouseY >= 450  && mouseY <= 950){
    if (l5Click == 0){
      l5Click = 1;
    }
    else {
      l5Click = 0;
    }
  }
  if(mouseX >= 1550 && mouseX <= 50+1550 && mouseY >= 450  && mouseY <= 950){
    if (l6Click == 0){
      l6Click = 1;
    }
    else {
      l6Click = 0;
    }
  }

  // Top Whites
  // rect(150,450,50,300);
  if(mouseX >= 150 && mouseX <= 50+150 && mouseY >= 450  && mouseY <= 750){
    if (top1Click == 0){
      top1Click = 1;
    }
    else {
      top1Click = 0;
    }
  }

  if(mouseX >= 250 && mouseX <= 50+250 && mouseY >= 450  && mouseY <= 750){
    if (top2Click == 0){
      top2Click = 1;
    }
    else {
      top2Click = 0;
    }
  }
  if(mouseX >= 400 && mouseX <= 50+400 && mouseY >= 450  && mouseY <= 750){
    if (top3Click == 0){
      top3Click = 1;
    }
    else {
      top3Click = 0;
    }
  }
  if(mouseX >= 500 && mouseX <= 50+500 && mouseY >= 450  && mouseY <= 750){
    if (top4Click == 0){
      top4Click = 1;
    }
    else {
      top4Click = 0;
    }
  }
  if(mouseX >= 600 && mouseX <= 50+600 && mouseY >= 450  && mouseY <= 750){
    if (top5Click == 0){
      top5Click = 1;
    }
    else {
      top5Click = 0;
    }
  }
  if(mouseX >= 750 && mouseX <= 50+750 && mouseY >= 450  && mouseY <= 750){
    if (top6Click == 0){
      top6Click = 1;
    }
    else {
      top6Click = 0;
    }
  }

  if(mouseX >= 850 && mouseX <= 50+850 && mouseY >= 450  && mouseY <= 750){
    if (top7Click == 0){
      top7Click = 1;
    }
    else {
      top7Click = 0;
    }
  }
  if(mouseX >= 1000 && mouseX <= 50+1000 && mouseY >= 450  && mouseY <= 750){
    if (top8Click == 0){
      top8Click = 1;
    }
    else {
      top8Click = 0;
    }
  }
  if(mouseX >= 1100 && mouseX <= 50+1100 && mouseY >= 450  && mouseY <= 750){
    if (top9Click == 0){
      top9Click = 1;
    }
    else {
      top9Click = 0;
    }
  }
  if(mouseX >= 1200 && mouseX <= 50+1200 && mouseY >= 450  && mouseY <= 750){
    if (top10Click == 0){
      top10Click = 1;
    }
    else {
      top10Click = 0;
    }
  }
  if(mouseX >= 1350 && mouseX <= 50+1350 && mouseY >= 450  && mouseY <= 750){
    if (top11Click == 0){
      top11Click = 1;
    }
    else {
      top11Click = 0;
    }
  }
  if(mouseX >= 1450 && mouseX <= 50+1450 && mouseY >= 450  && mouseY <= 750){
    if (top12Click == 0){
      top12Click = 1;
    }
    else {
      top12Click = 0;
    }
  }
  if(mouseX >= 1600 && mouseX <= 50+1600 && mouseY >= 450  && mouseY <= 750){
    if (top13Click == 0){
      top13Click = 1;
    }
    else {
top13Click = 0;
    }
  }
}