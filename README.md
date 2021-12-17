# SSO DEMO APPLICATION

## Logical Architecture

![SSO logical architecture](https://github.com/AswathyG/sso-demo/blob/main/static/vmware-drawio.png?raw=true)

## Explanation

### Steps

1. User tries to login to the web application of service provider
2. Service provider returns a response to the users browser with redirection to the Authorization server.
3. If user is not logged in, the Authorization server prompts for SSO creds
4. Upon providing the credentials , Authorization server verifies the user and sends a access token back to the browser
5. This access token is forwarded to the Service provider to gain access to the application
6. The Service provider and IDP would have pre configured trust agreement established

### Design Decisions

1. To gain high availability, the IDP instances can be deployed to multiple regions and served via a Load Balancer.
2. To achieve scalability, each IDP instance can be configured with Autoscaling
