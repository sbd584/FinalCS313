import ddf.minim.*;
import ddf.minim.analysis.*;
import ddf.minim.effects.*;
import ddf.minim.signals.*;
import ddf.minim.spi.*;
import ddf.minim.ugens.*;

Minim minim;

//from official minim website
// for recording
AudioInput in;
AudioRecorder recorder;
boolean recorded;
// for playing back
AudioOutput out;
FilePlayer player;



MiddleKey mk;
LeftKey lk;
WhiteKey wk;
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
ArrayList<MasterKey> keyboard;
void setup() {
  size(1800, 1000);
  minim = new Minim(this);
    // get a stereo line-in: sample buffer length of 2048
  // default sample rate is 44100, default bit depth is 16
  in = minim.getLineIn(Minim.MONO, 2048);
  
  // create an AudioRecorder that will record from in to the filename specified.
  // the file will be located in the sketch's main folder.
  recorder = minim.createRecorder(in, "myrecording.wav");
  
  // get an output we can playback the recording on
  out = minim.getLineOut( Minim.MONO );
  
  
  
  //Minim stuff
  keys = new ArrayList<AudioSample>();
  for(int i=0;i<32;i++){
    keyName = "jobro__piano-ff-088 ("+nf(i+1+32)+").wav";
    keyNote = minim.loadSample(keyName,512);
    keys.add(keyNote);
  }
  
  //keyboard stuff
  keyboard = new ArrayList<MasterKey>();
  for(int i=0;i<3;i++){
    lk = new LeftKey(i*600+100,450,i*12);
    keyboard.add(lk);
    lk = new LeftKey(i*600 + 350,450,5+i*12);
    keyboard.add(lk);
  }
  for(int i = 0;i<2;i++){
    wk = new WhiteKey(600*i+150,450,1+i*13);
    keyboard.add(wk);
    wk = new WhiteKey(600*i+250,450,3+i*13);
    keyboard.add(wk);
    wk = new WhiteKey(600*i+400,450,6+i*13);
    keyboard.add(wk);
    wk = new WhiteKey(600*i+500,450,8+i*13);
    keyboard.add(wk);
    wk = new WhiteKey(600*i+600,450,10+i*13);
    keyboard.add(wk);
  }
  wk = new WhiteKey(1350,450,26);
  keyboard.add(wk);
  wk = new WhiteKey(1450,450,28);
  keyboard.add(wk);
  wk = new WhiteKey(1600,450,31);
  keyboard.add(wk);
  for(int i = 0;i<2;i++){
    mk = new MiddleKey(600*i+150,450,1+i*13,color(200,200,300));
    keyboard.add(mk);
    mk = new MiddleKey(600*i+250,450,3+i*13,color(200,300,200));
    keyboard.add(mk);
    mk = new MiddleKey(600*i+400,450,6+i*13,color(200,200,300));
    keyboard.add(mk);
    mk = new MiddleKey(600*i+500,450,8+i*13,color(200,300,200));
    keyboard.add(mk);
    mk = new MiddleKey(600*i+600,450,10+i*13,color(200,200,300));
    keyboard.add(mk);
  }
  
  mk = new MiddleKey(1350,450,26,color(200,200,300));
  keyboard.add(mk);
  mk = new MiddleKey(1450,450,28,color(200,300,200));
  keyboard.add(mk);
  mk = new MiddleKey(1600,450,31,color(200,200,300));
  keyboard.add(mk);
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
    pushMatrix();
    fill(255);
    rect(100, 450, 1600, 500);
    popMatrix();
    // Middle and right keys
    // Left keys
    for(MasterKey ckey:keyboard){
      ckey.display();
    }
    
    for(int i = 0; i < in.bufferSize() - 1; i++)
    {
    line( i, 50 + in.left.get(i)*50, i+1, 50 + in.left.get(i+1)*50 );
    line( i, 150 + in.right.get(i)*50, i+1, 150 + in.right.get(i+1)*50 );
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
}
void keyReleased()
{
  if ( !recorded && key == 'r' ) 
  {
    // to indicate that you want to start or stop capturing audio data, 
    // you must callstartRecording() and stopRecording() on the AudioRecorder object. 
    // You can start and stop as many times as you like, the audio data will 
    // be appended to the end of to the end of the file. 
    if ( recorder.isRecording() ) 
    {
      recorder.endRecord();
      recorded = true;
    }
    else 
    {
      recorder.beginRecord();
    }
  }
  if ( recorded && key == 's' )
  {
    // we've filled the file out buffer, 
    // now write it to a file of the type we specified in setup
    // in the case of buffered recording, 
    // this will appear to freeze the sketch for sometime, if the buffer is large
    // in the case of streamed recording, 
    // it will not freeze as the data is already in the file and all that is being done
    // is closing the file.
    // save returns the recorded audio in an AudioRecordingStream, 
    // which we can then play with a FilePlayer
    if ( player != null )
    {
        player.unpatch( out );
        player.close();
    }
    player = new FilePlayer( recorder.save() );
    player.patch( out );
    player.play();
  }
}