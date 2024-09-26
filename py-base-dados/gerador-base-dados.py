import json
from faker import Faker
import random

fake = Faker('pt_BR')

def generate_company():
    return {
        "nome": fake.company(),
        "endereco": {
            "rua": fake.street_name(),
            "numero": fake.building_number(),
            "cidade": fake.city(),
            "estado": fake.state_abbr()
        },
        "cnpj": fake.cnpj(),
        "dataFundacao": fake.date_between(start_date="-10y", end_date="today").isoformat()
    }

companies = [generate_company() for _ in range(100000)]  # Gera 1000 exemplos

# Salvar em arquivo JSON
with open('empresas3.json', 'w') as f:
    json.dump(companies, f, ensure_ascii=False, indent=4)
