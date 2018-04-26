class Middle_key extends MasterKey{
float x,y,c;
PShape mk;
Middle_key( float x, float y, float c){
  //this.sample = _sample;
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
  public void isClicked(){
    
  }
  public void display(){
    shape(mk,this.x,this.y);
  }
}