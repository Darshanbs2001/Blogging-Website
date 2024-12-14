import { Container } from "reactstrap"
import Base from "../../components/Base"
import NewFeed from "../../components/NewFeed"

function UserDashBoard() {
 
  return (
    <>
     <Base>
      <Container className="mt-3">
        <NewFeed/>
      </Container>

      </Base>
    </>
  )
}

export default UserDashBoard