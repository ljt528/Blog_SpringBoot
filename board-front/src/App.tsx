import React from 'react';
import './App.css';
import { commentListMock, latestBoardListMock, top3BoardListMock } from 'mocks';
import BoardItem from 'components/BoardItem';
import Top3Item from 'components/Top3Item';
import CommentItem from 'components/CommentItem';

function App() {
  return (
    <>
    <div style={{ padding: '0 20px', display: 'flex', flexDirection: 'column', gap: '30px' }}>
      {commentListMock.map(commentListItem => <CommentItem commentListItem={commentListItem}/>)}
    </div>
    </>
  );
}

export default App;
