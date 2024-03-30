from locust import HttpUser, task


class Product(HttpUser):
    @task
    def checkHealth(self):
        self.client.get("/health")
