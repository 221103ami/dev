import './App.css';
import BoardDetail from './component/BoardDetail';
import BoardList from './component/BoardList';
import Hello from './component/Hello';
import { BrowserRouter , Routes, Route, Link } from "react-router-dom";

function App() {
  return (
    <div className="App">
      
      <h1>환영합니다 ~~~</h1>

      <BrowserRouter>
        <nav>
          <Link to="/">기본 페이지로 이동하기</Link>
          <br />
          <Link to="main">헬로 페이지로 이동하기</Link>
          <br />
          <Link to="board/list">게시글 목록 페이지로 이동하기</Link>
        </nav>

        <hr />

        <Routes>
          <Route path="/" element={ <h1>기본페이지</h1> } />
          <Route path='/main' element={ <Hello /> } />
          <Route path='/board/list' element={ <BoardList /> } />
          <Route path='/board/detail/:num' element={ <BoardDetail /> } />
          <Route path='/*' element={ <h1>404 낫파운드 ㅋㅋ</h1> } />
        </Routes>
      </BrowserRouter>

    </div>
  );
}

export default App;
