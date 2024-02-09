package customer.action;

import com.google.protobuf.Empty;
import customer.api.CustomerApi;
import customer.api.CustomerService;
import customer.api.PublisherApi;
import kalix.javasdk.action.ActionCreationContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// This class was initially generated based on the .proto definition by Kalix tooling.
// This is the implementation for the Action Service described in your customer/api/customer_action.proto file.
//
// As long as this file exists it will not be overwritten: you can maintain it yourself,
// or delete it so it is regenerated as needed.

public class CustomerActionImpl extends AbstractCustomerAction {

  final private Logger logger = LoggerFactory.getLogger(CustomerActionImpl.class);
  final private CustomerService customerService;

  public CustomerActionImpl(ActionCreationContext creationContext) {
    this.customerService = creationContext.getGrpcClient(CustomerService.class, "customer-registry");
  }

  @Override
  public Effect<Empty> processCustomerCreated(PublisherApi.Created created) {
    logger.info("################## CREATED ##################");
    logger.info("################## CREATED ##################");
    logger.info(created.toString());
    logger.info("################## CREATED ##################");
    logger.info("################## CREATED ##################");
    return effects().reply(Empty.getDefaultInstance());
  }

  @Override
  public Effect<Empty> processCustomerNameChanged(PublisherApi.NameChanged nameChanged) {
    logger.info("################## NAME CHANGED ##################");
    logger.info("################## NAME CHANGED ##################");
    logger.info(nameChanged.toString());
    logger.info("################## NAME CHANGED ##################");
    logger.info("################## NAME CHANGED ##################");
    return effects().reply(Empty.getDefaultInstance());
  }

  @Override
  public Effect<Empty> create(CustomerApi.Customer customer) {
    logger.info("Creating customer on customer-registry service {}", customer);
    return effects().asyncReply(customerService.create(customer));
  }
}
