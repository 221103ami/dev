import { useEffect, useState } from "react";

export default function BoardList(){

    const [tempList , setTempList] = useState([{}]);

    useEffect( ()=>{
        fetch("http://127.0.0.1:8888/board/list" , {})
        .then( resp => { return resp.json()} )
        .then( boardVoList => { 
            setTempList(boardVoList);
        } );
    } , [] );

    return <>
        <table border="1">
            <thead>
                <tr>
                    <th>번호</th>
                    <th>제목</th>
                    <th>작성일시</th>
                    <th>조회수</th>
                </tr>
            </thead>
            <tbody>
                {tempList.map( vo => { <tr>
                    <td>{vo.no}</td>
                    <td>{vo.title}</td>
                    <td>{vo.enroll_date}</td>
                    <td>{vo.hit}</td>
                    </tr> })}
            </tbody>
        </table>
    </>
}