class Middle_key{
float x,y,c;
PShape mk;
Middle_key(float x, float y, float c){
  this.x = x;
  this.y = y;

  mk = createShape(GROUP);
  // fill if
  if(c == 1){
    fill(200,300,200);
  }
  else if(c == 2){
    fill(0);
  }
  else{
    fill(200,200,300);
  }


  noStroke();
  mk.addChild(createShape(RECT,50,0,50,300));
  mk.addChild(createShape(RECT,0,300,100,200));
}

  public void display(){
    shape(mk,this.x,this.y);
  }

}

class Wave{
  PShape wave;
  int start, end;
  float depth, amplitude, phaseShift, x, y, speed;

  Wave(int start, int end, float depth, float amplitude, float phaseShift, float speed){
      this.start = start;
      this.end = end;
      this.depth = depth;
      this.amplitude = amplitude;
      this.phaseShift = phaseShift;
      this.speed = speed;
  }

  void display(){
    wave = createShape();
    wave.beginShape();
    // This changes the wave color
    wave.fill(color(137,0,216));
    //
    for(int i = start; i <= end; i+=10){
      x = i;
      y = amplitude * sin(x * PI / 180 + phaseShift) + depth;
      wave.vertex(x, y);
      }
      wave.vertex(end, 425);
      wave.vertex(start, 425);
      wave.endShape();
      shape(wave);
  }
  void moveWave(){
      // Change this for speed
      this.phaseShift += speed;
  }
}

Middle_key mk1;
Middle_key mk2;
Middle_key mk3;
Middle_key mk4;
Middle_key mk5;
Middle_key mk6;
Middle_key mk7;
Middle_key mk8;
Middle_key mk9;
Middle_key mk10;
Middle_key mk11;
Middle_key mk12;
Middle_key mk13;
Middle_key mk_1;
Middle_key mk_2;
Middle_key mk_3;
Middle_key mk_4;
Middle_key mk_5;
Middle_key mk_6;
Middle_key mk_7;
Middle_key mk_8;
Middle_key mk_9;
Middle_key mk_10;
Middle_key mk_11;
Middle_key mk_12;
Middle_key mk_13;
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
// Default
Wave wave0;
// Rest
Wave wave1;
Wave wave2;
Wave wave3;
Wave wave4;
Wave wave5;
Wave wave6;
Wave wave7;
Wave wave8;
Wave wave9;
Wave wave10;
Wave wave11;
Wave wave12;
Wave wave13;
Wave wave14;
Wave wave15;
Wave wave16;
Wave wave17;
Wave wave18;
Wave wave19;
Wave wave20;
Wave wave21;
Wave wave22;
Wave wave23;
Wave wave24;
Wave wave25;
Wave wave26;
Wave wave27;
Wave wave28;
Wave wave29;
Wave wave30;
Wave wave31;
Wave wave32;
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

void setup() {
  size(1800, 1000);

  // Default Wave
  wave0 = new Wave(200, 1600, 325, 100, .1,1);

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
  wave1 = new Wave(200, 1600, 325, 100, .1,18); // 2
  wave2 = new Wave(200, 1600, 325, 100, .1,17); // 3
  wave3 = new Wave(200, 1600, 325, 100, .1,15); // 5
  wave4 = new Wave(200, 1600, 325, 100, .1,14); // 6
  wave5 = new Wave(200, 1600, 325, 100, .1,13); // 7
  wave6 = new Wave(200, 1600, 325, 100, .1,11); // 9
  wave7 = new Wave(200, 1600, 325, 100, .1,10); // 10
  wave8 = new Wave(200, 1600, 325, 100, .1,8); // 12
  wave9 = new Wave(200, 1600, 325, 100, .1,7); // 13
  wave10 = new Wave(200, 1600, 325, 100, .1,6); // 14
  wave11 = new Wave(200, 1600, 325, 100, .1,4); // 16
  wave12 = new Wave(200, 1600, 325, 100, .1,3); // 17
  wave13 = new Wave(200, 1600, 325, 100, .1,1); // 19

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

  // Left key
  wave14 = new Wave(200, 1600, 325, 100, .1,19); // 1
  wave15 = new Wave(200, 1600, 325, 100, .1,16); // 4
  wave16 = new Wave(200, 1600, 325, 100, .1,12); // 8
  wave17 = new Wave(200, 1600, 325, 100, .1,9); // 11
  wave18 = new Wave(200, 1600, 325, 100, .1,5); // 15
  wave19 = new Wave(200, 1600, 325, 100, .1,2); // 18

  // Top Key
  wave20 = new Wave(200, 1600, 325, 100, .1,1.4);
  wave21 = new Wave(200, 1600, 325, 100, .1,1.3);
  wave22 = new Wave(200, 1600, 325, 100, .1,1.2);
  wave23 = new Wave(200, 1600, 325, 100, .1,1.1);
  wave24 = new Wave(200, 1600, 325, 100, .1,.9);
  wave25 = new Wave(200, 1600, 325, 100, .1,.8);
  wave26 = new Wave(200, 1600, 325, 100, .1,.7);
  wave27 = new Wave(200, 1600, 325, 100, .1,.6);
  wave28 = new Wave(200, 1600, 325, 100, .1,.5);
  wave29 = new Wave(200, 1600, 325, 100, .1,.4);
  wave30 = new Wave(200, 1600, 325, 100, .1,.3);
  wave31 = new Wave(200, 1600, 325, 100, .1,.2);
  wave32 = new Wave(200, 1600, 325, 100, .1,.1);

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
      }
      waveN = 19;
    }

    // White peices
    if(top1Click == 1){
      if(clickCount <= 10){
        fill(0);
        rect(150,450,50,300);
        clickCount += 1;
      }
      else{
        clickCount = 0;
        top1Click = 0;
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
      }
      waveN = 13;
    }

    // Wave


    if(waveN == 0){
      wave0.display();
      wave0.moveWave();
    }
    else if(waveN == 1){
      wave1.display();
      wave1.moveWave();
    }
    else if(waveN == 2){
      wave2.display();
      wave2.moveWave();
    }
    else if(waveN == 3){
      wave3.display();
      wave3.moveWave();
    }
    else if(waveN == 4){
      wave4.display();
      wave4.moveWave();
    }
    else if(waveN == 5){
      wave5.display();
      wave5.moveWave();
    }
    if(waveN == 6){
      wave6.display();
      wave6.moveWave();
    }
    else if(waveN == 7){
      wave7.display();
      wave7.moveWave();
    }
    else if(waveN == 8){
      wave8.display();
      wave8.moveWave();
    }
    else if(waveN == 9){
      wave9.display();
      wave9.moveWave();
    }
    else if(waveN == 10){
      wave10.display();
      wave10.moveWave();
    }
    else if(waveN == 11){
      wave11.display();
      wave11.moveWave();
    }
    else if(waveN == 12){
      wave12.display();
      wave12.moveWave();
    }
    else if(waveN == 13){
      wave13.display();
      wave13.moveWave();
    }
    else if(waveN == 14){
      wave14.display();
      wave14.moveWave();
    }
    else if(waveN == 15){
      wave15.display();
      wave15.moveWave();
    }
    else if(waveN == 16){
      wave16.display();
      wave16.moveWave();
    }
    else if(waveN == 17){
      wave17.display();
      wave17.moveWave();
    }
    else if(waveN == 18){
      wave18.display();
      wave18.moveWave();
    }
    else if(waveN == 19){
      wave19.display();
      wave19.moveWave();
    }
    else if(waveN == 20){
      wave20.display();
      wave20.moveWave();
    }
    else if(waveN == 21){
      wave21.display();
      wave21.moveWave();
    }
    else if(waveN == 22){
      wave22.display();
      wave22.moveWave();
    }
    else if(waveN == 23){
      wave23.display();
      wave23.moveWave();
    }
    else if(waveN == 24){
      wave24.display();
      wave24.moveWave();
    }
    else if(waveN == 25){
      wave25.display();
      wave25.moveWave();
    }
    else if(waveN == 26){
      wave26.display();
      wave26.moveWave();
    }
    else if(waveN == 27){
      wave27.display();
      wave27.moveWave();
    }
    else if(waveN == 28){
      wave28.display();
      wave28.moveWave();
    }
    else if(waveN == 29){
      wave29.display();
      wave29.moveWave();
    }
    else if(waveN == 30){
      wave30.display();
      wave30.moveWave();
    }
    else if(waveN == 31){
      wave31.display();
      wave31.moveWave();
    }
    else if(waveN == 32){
      wave32.display();
      wave32.moveWave();
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
