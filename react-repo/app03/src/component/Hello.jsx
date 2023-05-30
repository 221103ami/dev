import MyName from "./MyName";
import MyAge from "./MyAge";

export default function(){
    return <>
        <MyName />
        <MyAge />
    </>
}

//중괄호 를 이용해서 JS 표현식 작성 가능
//중괄호 안에서는 변수 사용 가능, 연산 가능
//boolean , 객체 는 표현 불가능
//camelCase 로 작성 //background-color => backgroundColor