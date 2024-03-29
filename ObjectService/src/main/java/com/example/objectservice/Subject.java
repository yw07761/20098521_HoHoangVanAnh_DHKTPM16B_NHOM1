package com.example.objectservice;

public class Subject {
        private Long subId;
        private String name;
        private int credit;

        // Constructors, getters, setters

        public Long getSubId() {
                return subId;
        }

        public void setSubId(Long subId) {
                this.subId = subId;
        }

        public String getName() {
                return name;
        }

        public void setName(String name) {
                this.name = name;
        }

        public int getCredit() {
                return credit;
        }

        public void setCredit(int credit) {
                this.credit = credit;
        }
}
