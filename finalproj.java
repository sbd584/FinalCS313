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
  float depth, amplitude, phaseShift, x, y;

  Wave(int start, int end, float depth, float amplitude, float phaseShift){
      this.start = start;
      this.end = end;
      this.depth = depth;
      this.amplitude = amplitude;
      this.phaseShift = phaseShift;
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
      this.phaseShift += 0.4;
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
int clickCount = 0;
Wave wave1;
float mute = 0;
float record = 0;
float record_dot = 0;
float stop = 0;
float play = 0;
float GUI_change = 1;
PFont font;
String string1 = " Hello and Welcome ";
String string2 = " Click To Continue ";
int gui2Timer;
int gui2Timer2;
int gui2TimerCycle;
int textWidth;

void setup() {
  size(1800, 1000);

  // GUI 1

  // GUI 2
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
  wave1 = new Wave(200, 1600, 325, 100, .1);

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
    rect(350,450,50,500);
    rect(700,450,50,500);
    rect(950,450,50,500);
    rect(1300,450,50,500);
    rect(1550,450,50,500);

    wave1.display();
    wave1.moveWave();


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
    }

  }

}

void mouseClicked() {
  // Record
  if(dist (315,120,mouseX,mouseY) <= 50){
    if (record == 0 ) {
      record = 255;
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

// mk11 = new Middle_key(1350,450,0);
// mk12 = new Middle_key(1450,450,1);
// mk13 = new Middle_key(1600,450,0);


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

}
