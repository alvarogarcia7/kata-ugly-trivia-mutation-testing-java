.PHONY: mutate
mutate:
	./mvnw clean package org.pitest:pitest-maven:mutationCoverage

.PHONY: mutate-save
mutate-save:
	git add .
	git commit -am "Mutation: execute tests"


