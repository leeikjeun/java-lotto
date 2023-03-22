package lotto.domain;

import lotto.domain.LottoTicket;
import lotto.domain.LottoRank;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.*;


public class LottoTicketTest {


    @Test
    @DisplayName("문자열을 받아 로또 번호를 만들 수 있다.")
    public void initLottoTikcetByString() {

        String lottoNumbers = "1, 2, 3, 4, 5, 6";

        LottoTicket lottoTicket = new LottoTicket(lottoNumbers);

        Set<LottoNumber> lottoNumber = lottoTicket.getLottoNumbers();

        assertThat(lottoNumber)
                .hasSize(6);
    }


    @DisplayName("로또 길이 6개 정합성 체크")
    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4,5,6,7", "1,2,3,4,5"})
    public void vaildLottoLength(String lottoNumbers) {

        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    // when
                    LottoTicket lottoTicket = new LottoTicket(lottoNumbers);

                }).withMessageContaining("로또 정합성 에러");

    }

    @DisplayName("로또 번호 중복 체크")
    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4,5,5", "1,2,3,4,6,6"})
    void vaildDuplicateLottoNumbers(String lottoNumbers) {

        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    // when
                    LottoTicket lottoTicket = new LottoTicket(lottoNumbers);

                }).withMessageContaining("정합성 에러");
    }

    @DisplayName("랜덤으로 번호 뽑을 수 있다.")
    @Test
    public void makeRandomLottoNumbers() {

        LottoTicket lottoTicket = new LottoTicket();

        Set<LottoNumber> lottoNumbers = lottoTicket.getLottoNumbers();

        assertThat(lottoNumbers)
                .hasSize(6);
    }

    @DisplayName("번호를 뽑으면 정렬이 되어있다.")
    @Test
    public void sortedLottoNumbers(){

        LottoTicket autoLottoTicket = new LottoTicket();
        LottoTicket manualLotto = new LottoTicket("5,4,3,2,1,9");


        List<LottoNumber> autoLottoSortNumbers = autoLottoTicket.getLottoNumbers().stream()
                .sorted(Comparator.comparingInt(LottoNumber::getLottoNumber))
                .collect(Collectors.toList());

        assertThat(autoLottoTicket.getLottoNumbers().stream().collect(Collectors.toList()))
                .containsExactly(autoLottoSortNumbers.toArray(new LottoNumber[autoLottoSortNumbers.size()]));

        List<LottoNumber> manualLottoSortNumbers = manualLotto.getLottoNumbers()
                .stream()
                .sorted()
                .collect(Collectors.toList());

        assertThat(manualLotto.getLottoNumbers().stream().collect(Collectors.toList()))
                .containsExactly(manualLottoSortNumbers.toArray(new LottoNumber[manualLottoSortNumbers.size()]));


    }


}
