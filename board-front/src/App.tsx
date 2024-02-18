import React from 'react';
import './App.css';
import { latestBoardListMock } from 'mocks';
import BoardItem from 'components/BoardItem';

function App() {
  return (
    <>
    {latestBoardListMock.map(boardListItem => <BoardItem boardListItem={boardListItem} />)}    
    </>
  );
}

export default App;
