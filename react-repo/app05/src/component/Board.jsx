import BoardTr from "./BoardTr";
import dummy from "../db/data.json";

export default function Board(){

    const trList = [];
    for(let i = 0; i < dummy.board.length; ++i){
        const t = dummy.board[i].title;
        const h = dummy.board[i].hit;
        const id = dummy.board[i].id;
        trList.push( <BoardTr key={id} title={t} writer="홍길동" hit={h}/> );
    }

    

    return <>
        <table>
            <thead>
                <tr>
                    <th>제목</th>
                    <th>작성자</th>
                    <th>조회수</th>
                </tr>
            </thead>
            <tbody>
                {trList}
            </tbody>
        </table>
    </>

}