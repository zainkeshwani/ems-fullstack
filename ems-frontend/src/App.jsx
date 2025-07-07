import EmployeeComponent from "./components/EmployeeComponent";
import FooterComponent from "./components/FooterComponent";
import HeaderComponent from "./components/HeaderComponent";
import ListEmployees from "./components/ListEmployees";
import {BrowserRouter, Route, Routes} from 'react-router-dom'

function App() {

  return (
    <>
      <BrowserRouter>
        <HeaderComponent/>
          <Routes>
            {/* // http://localhost:3000 */}
            <Route path='/' element = {<ListEmployees/>}></Route>

            {/* // http://localhost:3000/employees */}
            <Route path='/employees' element = {<ListEmployees/>}></Route>

            {/* // http://localhost:3000/add-employee */}
            <Route path='/add-employee' element = {<EmployeeComponent/>}></Route>

            {/* // http://localhost:3000/edit-employee/{id} */}
            <Route path='/edit-employee/:id' element = {<EmployeeComponent/>}></Route>
          </Routes>
        <FooterComponent/>
      </BrowserRouter>
    </>
  )
}

export default App