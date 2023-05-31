import { Link } from "react-router-dom";

export default function BoardListTr( {id, title, writer, hit} ){

    return <>
        <tr>
            <td><Link to={`/board/detail/${id}`}>{title}</Link></td>
            <td>{writer}</td>
            <td>{hit}</td>
        </tr>
    </>
}