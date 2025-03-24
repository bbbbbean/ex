package Ch12.ex;

// Exercise 3: Multi Level
class Shape {
    void draw() {
        System.out.println("도형을 그립니다");
    }
}

class Circle extends Shape {
    void draw() {
        System.out.println("원을 그립니다");
    }
    
    void calculateArea() {
        System.out.println("원의 넓이를 계산합니다");
    }
}

class ColoredCircle extends Circle {
    void draw() {
        System.out.println("색칠된 원을 그립니다");
    }
    
    void applyColor() {
        System.out.println("원에 색을 칠합니다");
    }
}

public class Ex03MultiLevel {
    public static void main(String[] args) {
        System.out.println("=== 연습문제 3: 다중 레벨 ===");
        // 문제: 다음 단계를 수행하는 코드를 작성하세요
        // 1. ColoredCircle 인스턴스를 생성하고 Shape 타입으로 업캐스팅하세요
        // 2. 업캐스팅된 참조로 draw() 메서드를 호출해보세요
        // 3. Shape -> Circle로 다운캐스팅하고 calculateArea() 메서드를 호출해보세요
        // 4. Circle -> ColoredCircle로 다운캐스팅하고 applyColor() 메서드를 호출해보세요
        // 5. 각 단계에서 어떤 메서드에 접근 가능한지 확인해보세요
        ColoredCircle color = new ColoredCircle();
        Shape colorCircle = color;
        colorCircle.draw();
        if(colorCircle instanceof Circle) {
        	((Circle) colorCircle).calculateArea();
        }
        if(colorCircle instanceof ColoredCircle) {
        	((ColoredCircle) colorCircle).applyColor();
        }

        // 실행 결과 예시:
        // 색칠된 원을 그립니다
        // 원의 넓이를 계산합니다
        // 원에 색을 칠합니다
        
   
    }
} 