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