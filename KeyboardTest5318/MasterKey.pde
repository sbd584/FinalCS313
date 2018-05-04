class MasterKey{
  float x,y,c;
  int clickCount,index;
  AudioSample sample;
  boolean isClicked = false;
  void playNote(){
    if(this.isClicked == true){
      if(this.clickCount <= 10){
        fill(0);
        clickCount += 1;
      }
      else{
        clickCount = 0;
        this.isClicked = false;
        keys.get(this.index).trigger();
      }
    }
  }
  public void display(){
    this.playNote();
    this.display();
  }
}