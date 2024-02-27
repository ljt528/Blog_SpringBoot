import Footer from 'layouts/Footer';
import './App.css';
import { Route, Routes } from 'react-router-dom';
import Main from 'views/Main';
import Authentication from 'views/Authentication';
import Search from 'views/Search';
import User from 'views/User';
import BoardDetail from 'views/Board/Detail';
import BoardWrite from 'views/Board/Write';
import BoardUpdate from 'views/Board/Update';
import Container from 'layouts/Container';
import { AUTH_PATH, BOARD_DETAIL_PATH, BOARD_PATH, BOARD_UPDATE_PATH, BOARD_WRITE_PATH, MAIN_PATH, SEARCH_PATH, USER_PATH } from 'constant';


//        component : Application 컴포넌트        //
function App() {

  //        render : Application 컴포넌트 렌더링        //
  //  description : 메인 페이지 : '/' - Main  //
  //  description : 로그인 페이지 + 회원가입 페이지 : '/auth' - Authentication  //
  //  description : 검색 페이지 : '/search/:searchWord' - Search  //
  //  description : 유저 페이지 : '/user/:userEmail' - User  //
  //  description : 게시물 상세보기 페이지 : '/board/detail/:boardNumber' - BoardDetail  //
  //  description : 게시물 작성하기 페이지 : '/board/write' - BoardWrite  //
  //  description : 게시물 수정하기 페이지 : '/board/update/:boardNumber' - BoardUpdate  //
  // ※ 참고 : board - path에서 detail을 제일 뒤로 넣어야 안전하게 작업됨!(앞에서부터 읽기 때문에)
  return (
    <Routes>
      <Route element={<Container />}>
        <Route path={MAIN_PATH()} element={<Main />} />
        <Route path={AUTH_PATH()} element={<Authentication />} />
        <Route path={SEARCH_PATH(':searchWord')} element={<Search />} />
        <Route path={USER_PATH('userEmail')} element={<User />} />
        <Route path={BOARD_PATH()}>
          <Route path={BOARD_WRITE_PATH()} element={<BoardWrite />} />
          <Route path={BOARD_DETAIL_PATH(':boardNumber')} element={<BoardDetail />} />
          <Route path={BOARD_UPDATE_PATH(':boardNumber')} element={<BoardUpdate />} />
        </Route>
        <Route path='*' element={<h1>404 Not Found</h1>} />
      </Route>
    </Routes>
  );
};

export default App;
