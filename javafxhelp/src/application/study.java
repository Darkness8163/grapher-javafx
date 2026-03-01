package application;

class study {
    public static void main(String[] args)
    {
        System.out.println("Hello ABC");
        
        double x=0,y=0,SpanX,SpanY,detailX,detailY,SpanXCounter=0;
        detailX = 0.5;
        detailY = 1;
        SpanX=100;
        SpanY=200;
        x = x - SpanX/2;
        while(SpanXCounter<SpanX){
            y = Graph.MathFunction(x) + SpanY/2;
            Graph.PlotResultAndXAxis(x + SpanX/2, y, SpanY, SpanX);
            SpanXCounter=SpanXCounter+detailX;
            x=x+detailX;
        }
    }
            
    
    public static class Graph {
        static double MathFunction(double x){
            double y;    
            
            y = x*x;//10*Math.sin(0.1*x*Math.PI);    // mathematical function, modify this
            
            return y;   
        }
        static void PlotResultAndXAxis(double x, double y, double SpanY, double SpanX){
            
            int i;
            int y2=(int)y;
            for(i=0;i<SpanY;i++){
                
                if(!(x-SpanX/2==0)){
                    if(i<SpanY && (i<y2)) {
                        System.out.print(" ");
                    }
                    if(i==y2) {
                        System.out.print("I");
                        System.out.print("(x = " + (x-SpanX/2) + " , y = " + (y2-SpanY/2) + ")");
                    }
                    /*if(i<y){
                        System.out.print("-");
                    }*/
                    if(i==SpanY/2 && !(i==y2)) { // prints the x axis
                        System.out.print("o"); 
                    }
                } else {System.out.print("o");}
            }
            System.out.println(" ");
        }
            

    }
}