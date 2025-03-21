package Ch34;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

// 언제 동작할 것인지 실행, 적용 범위 지정 가능
// 어노테이션 유지기간 : runtime - 프로그램 동작 중인 상태에서만 실행
@Retention(RetentionPolicy.RUNTIME)	

// 타겟
// 어떤 클래스에 어노테이션을 쓸건데, 그 클래스의 속성과 메소드에 적용할 것
@Target({ElementType.TYPE,ElementType.METHOD})

// 어노테이션 : @를 사용하여 작성, 알림
public @interface CustomAnnotation {
	// 속성에 전달 할 내용 : value, number라는 이름으로 전달
	String value() default "";
	int number() default 0;
	boolean isOpen () default false;
}
