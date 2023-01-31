package e3;

public record Triangle(float angle0, float angle1, float angle2){

    public Triangle{
        if(angle0+angle1+angle2!=180){ //Comprobamos se se trata dun triangulo valido
            throw new IllegalArgumentException("Os angulos dun triangulo deben sumar 180º");
        }
    }

    public Triangle(Triangle t){
        this(t.angle0, t.angle1, t.angle2);
    }
    //Diferentes tipos de triangulos validos
    public boolean isRight(){
        return this.angle0 == 90 || this.angle1 == 90 || this.angle2 == 90;
    }

    public boolean isAcute(){
        return this.angle0 < 90 && this.angle1  < 90 && this.angle2 < 90;
    }

    public boolean isObtuse(){
        return this.angle0 > 90 || this.angle1  > 90 || this.angle2 > 90;
    }

    public boolean isEquilateral(){return this.angle0 == this.angle1  && this.angle1  == this.angle2;}

    public boolean isIsosceles(){return this.angle0 == this.angle1 || this.angle1 == this.angle2 || this.angle0 == this.angle2;}

    public boolean isScalene(){
        return !isEquilateral() && !isIsosceles();
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = (int) (13 * hash + (this.angle0 * this.angle1 * this.angle2));
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (obj.getClass() != this.getClass()) {
            return false;
        }
        Triangle r = (Triangle) obj;
        if ((this.angle0 == r.angle2) && (this.angle2==r.angle1) && (this.angle1==r.angle0)){
            return true;
        }

        if((this.angle0==r.angle1) && (this.angle2==r.angle0) && (this.angle1==r.angle2)){
            return true;
        }
        if((this.angle0 == r.angle0) && (this.angle1 == r.angle1) && (this.angle2==r.angle2)){
            return true;
        }
        return false;
    }
}