import example.{SomeEntity, SomeServiceGrpc}
import example.SomeServiceGrpc.SomeService
import io.grpc.{Server, ServerBuilder}

import scala.concurrent.{ExecutionContext, Future}

object Main extends App {

  private val server: Server = ServerBuilder
    .forPort(4080)
    .addService(SomeServiceGrpc.bindService(new DefautSomeService, ExecutionContext.global))
    .build()
    .start()

  server.awaitTermination()

  sys.addShutdownHook {
    server.shutdown()
  }

  private class DefautSomeService extends SomeService {
    override def showEntity(request: SomeEntity): Future[SomeEntity] = {
      Future.successful(request.withMessage("Ahoyhoy from the server"))
    }
  }
}
