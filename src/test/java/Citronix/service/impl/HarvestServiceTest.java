package Citronix.service.impl;

import Citronix.dto.HarvestMapper;
import Citronix.dto.records.harvest.HarvestRequestDTO;
import Citronix.dto.records.harvest.HarvestResponseDTO;
import Citronix.exception.EntityNotFoundException;
import Citronix.model.Field;
import Citronix.model.Harvest;
import Citronix.model.Tree;
import Citronix.model.enums.Season;
import Citronix.repository.FieldRepository;
import Citronix.repository.HarvestDetailsRepository;
import Citronix.repository.HarvestRepository;
import Citronix.repository.TreeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

class HarvestServiceTest {
    @Mock
    private HarvestMapper harvestMapper;

    @Mock
    private HarvestRepository harvestRepo;

    @Mock
    private FieldRepository fieldRepository;

    @Mock
    private TreeRepository treeRepository;

    @Mock
    private HarvestDetailsRepository harvestDetRepo;

    @InjectMocks
    private HarvestService harvestService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void saveTest() {
        UUID fieldId = UUID.randomUUID();
        LocalDate createdAt = LocalDate.of(2024, 11, 1);
        HarvestRequestDTO requestDTO = new HarvestRequestDTO(createdAt,fieldId);
        Field field = new Field();
        field.setId(fieldId);

        Tree tree = new Tree();
        tree.setPlanted_at(LocalDate.of(2020, 1, 1));
        List<Tree> trees = List.of(tree);

        Harvest harvest = Harvest.builder()
                .field(field)
                .created_at(createdAt)
                .season(Season.FALL)
                .quantity(20.0)
                .build();

        HarvestResponseDTO responseDTO = new HarvestResponseDTO(harvest.getId(),  harvest.getCreated_at(),field);


        when(fieldRepository.findById(fieldId)).thenReturn(Optional.of(field));
        when(treeRepository.getTreesByFieldId(fieldId)).thenReturn(trees);
        when(harvestRepo.countByFieldId(fieldId)).thenReturn(0.0);
        when(harvestRepo.existsBySeasonAndFieldId(any(), eq(fieldId))).thenReturn(false);
        when(harvestMapper.toDTO(any(Harvest.class))).thenReturn(responseDTO);

     
        HarvestResponseDTO result = harvestService.save(requestDTO);

        assertNotNull(result);
        assertEquals(responseDTO, result);

        verify(fieldRepository).findById(fieldId);
        verify(treeRepository).getTreesByFieldId(fieldId);
        verify(harvestRepo).save(any(Harvest.class));
        verify(harvestDetRepo).save(any());
    }

    @Test
    void testSave_FieldNotFound() {
        UUID fieldId = UUID.randomUUID();
        LocalDate createdAt = LocalDate.of(2024, 11, 1);
        HarvestRequestDTO requestDTO = new HarvestRequestDTO(createdAt,fieldId);

        when(fieldRepository.findById(fieldId)).thenReturn(Optional.empty());

        EntityNotFoundException exception = assertThrows(EntityNotFoundException.class, () -> {
            harvestService.save(requestDTO);
        });

        assertEquals("entity not found", exception.getMessage());
        verify(fieldRepository).findById(fieldId);
        verifyNoInteractions(treeRepository, harvestRepo, harvestDetRepo);
    }

    @Test
    void getHarvestsTest() {
    }

    @Test
    void deleteHarvestTest() {
    }

    @Test
    void updateTest() {
    }
}