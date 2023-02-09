const btn01 = document.querySelector("#btn01");
btn01.addEventListener("click", function(){
    
    //정규표현식(==Regular Expression) 객체 생성

    // 생성방법 : new RegExp(패턴) , /패턴/

    // 정규표현식 메소드
    // test : 패턴을 만족하는 값이 있으면 true , 없으면 false
    // exec : 패턴을 만족하는 값이 있으면 처음 매치된 문자열 리턴
    
    // string 의 메소드 (정규표현식 사용 가능한)
    // match : 패턴값과 일치하는 값을 리턴
    // replace : 패턴값과 일치하는 값을 대체값으로 대체
    // search : 패턴값과 일치하는 부분의 시작인덱스를 리턴
    // split : 패턴값과 일치하는 부분을 기준으로 분리하여 배열 리턴

    // const re = new RegExp("abc");
    const re = /abc/;
    const str = 'helloabcworldabcbye';

    const result = re.test(str);
    const result2 = re.exec(str);
    const result3 = str.match(re);
    const result4 = str.replace(re , 'ㅋㅋㅋ');
    const result5 = str.search(re);
    const result6 = str.split(re);

    console.log(result);
    console.log(result2);
    console.log(result3);
    console.log(result4);
    console.log(result5);
    console.log(result6);
    
});

const btn02 = document.querySelector("#btn02");
btn02.addEventListener("click" , function(){

    const str = "JAvaScript jQuery Ajax";

    const result1 = str.replace(/j/gi , 'ㅋ');
    console.log(result1);

});


const btn03 = document.querySelector("#btn03");
btn03.addEventListener("click", function(){

    /*
        반복검색
        {m} : m번 반복
        {m,n} : 최소m번 최대n번 반복
        + : 최소 한번 이상 반복
        ? : 최대 한번 반복

    */

    var str = 'a aa aaa aaaa';

    var result = str.replace(/a{1,3}/g , 'ㅋ');
    console.log(result);

    //{1,}
    var result2 = str.replace(/a+/g, 'ㅋ');
    console.log(result2);

    //{0,1}
    var result3 = str.replace(/a?/g , 'X');
    console.log(result3);

    console.log("=========@@@@@@@@@");

    /*
        문자열의 처음 , 끝 구분
        ^ : 문자열 시작
        $ : 문자열 마지막
    */

    var str = "Javascript\nJQuery\nShellscript\nAjax";

    var result = str.replace(/^j/igm , 'ㅋ');
    console.log(result);

    var result = str.replace(/ipt$/igm , 'ㅋ');
    console.log(result);

    /*
        OR 검색
        [...] 내 문자들 중 하나라도 존재하는 경우
        ^ : [] 안에서 not 을 의미
        - : [] 안에서 범위지정을 의미 
    */

    console.log("=================");

    var str = "123 Javascript jQuery Ajax";

    var result = str.replace(/[0-9]/g , 'ㅋ');
    console.log(result);

    /*
        임의의 문자열 검색
        . : 한글자
    */

    console.log("===========");
    var str = "123 Javascript jQuery Ajax";

    var result = str.replace(/...../g , 'ㅋ');
    console.log(result);

    /*
        \d : 숫자
        \D : 숫자 X 문자
        \w : 알파벳,숫자,언더스코어
        \W : 알파벳,숫자,언더스코어 X 문자
        \s : 공백 (띄어쓰기,탭,줄바꿈)
        \S : 공백 X 문자
    */

    console.log("=========");

    var str = 'A1 B2 C3 d_4 e:5 ` ffgg77--__--\t가\n나\n다';

    //[0-9]
    var result = str.replace(/\d/g , 'ㅋ');
    console.log(result);

    //[^0-9]
    var result = str.replace(/\D/g , 'ㅋ');
    console.log(result);

    //[a-zA-Z0-9_]
    var result = str.replace(/\w/g , 'ㅋ');
    console.log(result);

    //[^a-zA-Z0-9_]
    var result = str.replace(/\W/g , 'ㅋ');
    console.log(result);

    //[ \t\n]
    var result = str.replace(/\s/g , 'ㅋ');
    console.log(result);

    //[^ \t\n]
    var result = str.replace(/\S/g , 'ㅋ');
    console.log(result);
});
