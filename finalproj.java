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
Wave wave1;
float mute = 0;
float record = 0;
float record_dot = 0;
float stop = 0;
float play = 0;
float GUI_change = 1;
PFont font;
String string1 = " Hello and Welcome ";;
String string2 = " Click To to Continue ";
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

      text(string2,400,900);

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
  }

}

void mouseClicked() {
  // ellipse(315, 120, 100, 100);
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
  // ellipse(1600, 140, 125, 125);
  if(dist (1600,140,mouseX,mouseY) <= (125/2)){
    if (mute == 0 ) {
      mute = 105;
    }
    else {
      mute = 0;
    }
  }

  // ellipse(200, 110, 75, 75);
  if(dist (200,110,mouseX,mouseY) <= (75/2)){
        if (stop == 0 ) {
      stop = 145;
    }
    else {
      stop = 0;
    }
  }

  //   ellipse(125, 110, 75, 75);
  if(dist (125,110,mouseX,mouseY) <= (75/2)){
        if (play == 0 ) {
      play = 90;
    }
    else {
      play = 0;
    }
  }
  if(gui2Timer2 > gui2Timer){
    GUI_change = 2;
  }

}
