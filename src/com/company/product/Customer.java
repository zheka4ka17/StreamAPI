package com.company.product;

public class Customer {
        private Long id;
        private String name;
        private Integer tier;

        public Customer(Long id, String name, Integer tier) {

            this.id
                    = id;

            this.name
                    = name;
            this.tier = tier;
        }

        public Long getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public Integer getTier() {
            return tier;
        }

        @Override
        public String toString() {
            return "Customer{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    ", tier=" + tier +
                    '}';
        }
    }

