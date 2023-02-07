//1. 변수와 자료형
// 전역 변수 선언
x1 = "함수밖에만든변수(전역변수임)"; 
var x2 = "함수밖에만든var변수(전역변수임)";
let x3 = "함수밖에만든let변수(전역변수)";
const x4 = "함수밖에만든const변수(전역변수)";

//console.log(x);

window.onload = function f01(){
    var x1 = "함수 내 var 변수";
    //console.log(window.x1);

    var x99;
    //console.log(x99);

    var b = true;
    var n = 123;
    var o = new Object();
    var f = function tempFunc(){}
    //typeof
    console.log( typeof x1 );
    console.log( typeof x99 );
    console.log( typeof b );
    console.log( typeof n );
    console.log( typeof o );
    console.log( typeof f );

    console.log("==========================");

    // var , let , const
    // var : 재선언 가능 (할당자유롭게)
    // let : 재선언 불가 (java변수같음)
    // const : 재할당 불가(final 같음)


    // ===================================
    // 2) 유효범위 (스코프)
    // 함수 안에서 var 로 선언된 변수 : 함수스코프
    //console.log(temp);    //var 로 선언된 경우만 에러없음
    if(true){
        var temp = 123;
        console.log(temp);
    }
    console.log(temp);

    console.log("============================");
    console.log("=========강제형변환==========");

    parseInt('3');
    parseFloat('3.14');
    Number('123');
    String(777);

    const arr = [10,20,30];
    
    arr = [111,222,333];
    arr[0] = 777;

    // for(let i = 0 ; i < arr.length; ++i){
    //     console.log(arr[i]);
    // }

    for(let i in arr){  //arr 의 인덱스를 i 에 담아줌
        console.log(i); 
    }

    for(let x of arr){  //arr 의 요소를 x 에 담아줌
        console.log(x);
    }
    

}//window.onload function
