import { useEffect, useState } from "react";
import { useParams } from "react-router-dom"

export default function BoardDetail(){

    console.log("함수 실행됨 ...");
    const {num} = useParams();

    //기존에는 파일에서 직접 데이터를 읽어옴
    const [temp, setTemp] = useState('zzz');

    //useEffect : 컴포넌트 렌더링 시, 특정 작업 수행
    useEffect( ()=>{
        console.log("useEffect 동작 ~");
        //서버한테 요청을 보내서, 데이터를 받기
        fetch( `http://localhost:3333/board?id=${num}` , {} )
        .then( resp => { return resp.json()} )
        .then( result => {
            console.log("서버한테 응답 받음!");
            setTemp(result);
        } );
    } , []);

    console.log("요소 그리기");
    console.log(temp);
    return <>
        게시글 번호 : {temp[0].id}
        <br />
        제목 : {temp[0].title}
        <br />
        내용 : {temp[0].content}
        <br />
        작성자 : {temp[0].writer}
        <br />
        조회수 : {temp[0].hit}
    </>
}