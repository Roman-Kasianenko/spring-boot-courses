package com.bender.person;

import com.bender.SortingOrder;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Sort;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;

@SpringBootTest
class PersonServiceTest {

    @MockBean
    private PersonRepository personRepository;

    @MockBean
    private FakePersonRepository fakePersonRepository;

    @Autowired
    private PersonService personService;

    @Test
    void canGetAllPersons() {
        // given
        SortingOrder sort = SortingOrder.ASC;
        // when
        personService.getPeople(sort);
        // then
        ArgumentCaptor<Sort> captor = ArgumentCaptor.forClass(Sort.class);
        verify(personRepository).findAll(captor.capture());

        assertThat(captor.getValue()).isEqualTo(Sort.by(Sort.Direction.valueOf(sort.name()), "id"));
    }
}