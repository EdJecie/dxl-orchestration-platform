# DXL Orchestration Platform

This project is a backend DXL-style orchestration platform built with Spring Boot.
It demonstrates how a central orchestration layer coordinates multiple microservices
(Auth and Billing) with resilience, fault tolerance, and observability.

## Why I built this
I built this project to strengthen my understanding of:
- DXL orchestration patterns used in telco and banking systems
- Resilient microservice communication
- Circuit breakers, retries, and fallbacks
- High-traffic backend system design

## Architecture
- DXL Orchestrator (synchronous orchestration)
- Auth Service
- Billing Service
- Redis for caching
- Feign + Resilience for service-to-service calls

## Tech Stack
- Java 17
- Spring Boot
- Spring Cloud OpenFeign
- Resilience4j
- Redis
- Docker & Docker Compose

## Key Features
- Central orchestration layer (DXL)
- Circuit breakers and fallbacks
- Rate limiting
- Redis caching
- Centralized logging with correlation IDs
- Distributed tracing support

## How to run
```bash
docker-compose up --build
