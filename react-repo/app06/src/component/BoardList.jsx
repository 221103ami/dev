import BoardListTr from "./BoardListTr";
import dummy from "../db/data.json";

export default function BoardList(){



    return <>
        <table border="1">
            <thead>
                <tr>
                    <th>제목</th>
                    <th>작성자</th>
                    <th>조회수</th>
                </tr>
            </thead>
            <tbody>
                {
                    dummy.board.map( 
                        x => <BoardListTr key={x.id} id={x.id} title={x.title} writer={x.writer} hit={x.hit} />
                        )
                }
            </tbody>
        </table>
    </>
}