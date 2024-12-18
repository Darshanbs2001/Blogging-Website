import { Col, Container, Row } from "reactstrap"
import Base from "../../components/Base"
import NewFeed from "../../components/NewFeed"
import SideBar from "../../components/SideBar"

function UserDashBoard() {
 
  return (
    <>
     <Base>
      <Container className="mt-3">
        <Row>
          <Col className="py-5" md={{size:2}}>
            <SideBar/>
          </Col >
          <Col md={{
            size:10
            
          }}>
          <NewFeed/>
          </Col>

        </Row>
      
        
      </Container>

      </Base>
    </>
  )
}

export default UserDashBoard