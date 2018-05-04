
class Music_note {
float x,y,q,yd,xd;
PShape musicN;
Music_note(float x, float y,float q, float yd, float xd){
  // Creating Music Notes
  this.x = x;
  this.y = y;
  this.q = q;
  this.yd = yd;
  this.xd = xd;

  musicN = createShape(GROUP);

  noStroke();
  fill(0,180,0);

  musicN.addChild(createShape(ELLIPSE,25 + q,210,80,80));
  musicN.addChild(createShape(ELLIPSE,150 + q,210,80,80));
  musicN.addChild(createShape(RECT,25 + q,50,50,200,7));
  musicN.addChild(createShape(RECT,150 + q,50,50,200,7));
  musicN.addChild(createShape(RECT,25 + q,50,175,50,7));

  //Wings
  fill(255,223,0);
  musicN.addChild(createShape(RECT,60 + q,80,180,5,50,50,0,0));
  musicN.addChild(createShape(RECT,80 + q,85,160,5));
  musicN.addChild(createShape(RECT,100 + q,90,140,5));
  musicN.addChild(createShape(RECT,120 + q,95,120,5));
  musicN.addChild(createShape(ARC,70 + q,85,20,15,0, PI, CHORD));
  musicN.addChild(createShape(ARC,90 + q,90,20,20,0, PI, CHORD));
  musicN.addChild(createShape(ARC,110 + q,95,20,25,0, PI, CHORD));
  musicN.addChild(createShape(ARC,130 + q,100,20,30,0, PI, CHORD));
  musicN.addChild(createShape(ARC,150 + q,100,20,35,0, PI, CHORD));
  musicN.addChild(createShape(ARC,170 + q,100,20,40,0, PI, CHORD));
  musicN.addChild(createShape(ARC,190 + q,100,20,45,0, PI, CHORD));
  musicN.addChild(createShape(ARC,210 + q,100,20,55,0, PI, CHORD));
  musicN.addChild(createShape(ARC,230 + q,100,20,70,0, PI, CHORD));

  }

  // public Void Music Fill

  public void MusicMove(int music_timer){
    float mt = music_timer/10;
    //this.x = 400
    if(mt < 30){
      this.y += 2.2;
      //this.x = 400 + 10*mt;
      if(mt < 7.5){
        this.x += 1.8;
      }
      else if(mt < 15){
        this.x -= 1.8;
      }
      else if(mt < 22.5){
        this.x -= 1.8;
      }
      else{
        this.x += 1.8;
      }
    }
    else{
      this.y -= 2.2;
      //this.x = 700 - 10*mt;
      if(mt < (30 + 7.5)){
        this.x += 1.8;
      }
      else if(mt < (30 + 15)){
        this.x -= 1.8;
      }
      else if(mt < (30 + 22.5)){
        this.x -= 1.8;
      }
      else{
        this.x += 1.8;
      }
  }

  }

  public void minis(int music_timer){
    float mt = music_timer/50;


    noStroke();

    if (mt < 3){
      fill(255,0,255);
      yd -= .5;
      xd -= .5;
      if (mt <= 1.5){
        fill(255);
      }
    }
    else if (mt < 6){
      fill(255,255,0);
      yd += .5;
      xd -= .5;
      if (mt <= 4.5){
        fill(0,255,255);
      }
    }
    else if (mt < 9){
      fill(255,255,0);
      yd += .5;
      xd += .5;
      if (mt <= 7.5){
        fill(255,0,255);
      }
    }

    else if (mt <= 12){
      fill(0);
      yd -= .5;
      xd += .5;
      if (mt <= 10.5){
        fill(0,255,255);
      }
    }
    else{
      fill(0,255,255);
      yd = 0;
      xd = 0;

    }


    beginShape(GROUP);
    // Baby Note

    ellipse(x+175 + q+xd+25,y+175+yd,20.0,20.0);
    ellipse(x+200 + q+xd+25,y+175+yd,20.0,20.0);
    rect(x+175 + q+xd+25,y+140+yd,10,35,7);
    rect(x+200 + q+xd+25,y+140+yd,10,35,7);
    rect(x+175 + q+xd+25,y+140+yd,35,10,7);



  }


  public void display(int music_timer){

    this.MusicMove(music_timer);
    shape(musicN,this.x,this.y);
    this.minis(music_timer);
  }
}